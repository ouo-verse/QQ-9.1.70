package com.tencent.mobileqq.search.searchdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.search.searchdetail.SearchAnimPart;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0002GHB\u0007\u00a2\u0006\u0004\bD\u0010EJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010%\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010&\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010'\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005J\u001c\u0010+\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchAnimPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/gamecenter/api/ISearchPopService;", "K9", "", "url", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$c;", "listener", "", "I9", "", "id", "type", "maxCount", "", "G9", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/content/Context;", "context", "L9", "resfolder", "Lhe1/a;", "data", "keyword", "Q9", "Lcom/tencent/mobileqq/search/searchdetail/SearchAnimPart$Reason;", "reason", "P9", "view", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "M9", "action", "", "args", "handleBroadcastMessage", "", "timestamp", "H9", "Lcom/airbnb/lottie/LottieAnimationView;", "d", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieView", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mAnimRoot", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mCloseView", tl.h.F, "Lhe1/a;", "mCurrentData", "i", "J", "mAnimStartTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsDestroyed", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "Reason", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchAnimPart extends Part implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView mLottieView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mAnimRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mCloseView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private he1.a mCurrentData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mAnimStartTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDestroyed;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchAnimPart$Reason;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "RETURN", "SERACH", "CLOSE", "TIMEOUT", MyNearbyProBizScene.CLICK, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public enum Reason {
        NONE(0),
        RETURN(1),
        SERACH(2),
        CLOSE(3),
        TIMEOUT(4),
        CLICK(5);

        private final int value;

        Reason(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/search/searchdetail/SearchAnimPart$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SearchAnimPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.P9(Reason.TIMEOUT);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QLog.d("QQSearch.NetDetail.SearchAnimPart", 1, "onAnimationEnd");
            View partRootView = SearchAnimPart.this.getPartRootView();
            if (partRootView != null) {
                final SearchAnimPart searchAnimPart = SearchAnimPart.this;
                partRootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchAnimPart.b.b(SearchAnimPart.this);
                    }
                }, 2000L);
            }
        }
    }

    private final void F9(int id5, int type) {
        List list;
        if (type == 0) {
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(context, QMMKVFile.FILE_COMMON)");
        String str = "anim_key_" + id5;
        String string = fromV2.getString(str, "", true);
        String H9 = H9(System.currentTimeMillis());
        if (TextUtils.isEmpty(string)) {
            fromV2.putString(str, "1;" + ((Object) H9), true);
            return;
        }
        if (string != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{";"}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        if (list != null) {
            if (list.size() == 2) {
                int parseInt = Integer.parseInt((String) list.get(0));
                String str2 = (String) list.get(1);
                if (type != 1) {
                    if (type != 2) {
                        return;
                    }
                    fromV2.putString(str, parseInt + ";" + ((Object) H9), true);
                    return;
                }
                if (Intrinsics.areEqual(str2, H9)) {
                    fromV2.putString(str, (parseInt + 1) + ";" + ((Object) H9), true);
                    return;
                }
                fromV2.putString(str, "1;" + ((Object) H9), true);
                return;
            }
            QLog.e("QQSearch.NetDetail.SearchAnimPart", 1, "[addAnimShowCount] err, countInfo: " + ((Object) string));
            fromV2.putString(str, "1;" + ((Object) H9), true);
        }
    }

    private final boolean G9(int id5, int type, int maxCount) {
        List list;
        if (type == 0) {
            return true;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(context, QMMKVFile.FILE_COMMON)");
        String string = fromV2.getString("anim_key_" + id5, "", true);
        if (QLog.isColorLevel()) {
            QLog.d("QQSearch.NetDetail.SearchAnimPart", 1, "[canShowAnim] countInfo: " + ((Object) string));
        }
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        if (string != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{";"}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        if (list != null) {
            if (list.size() == 2) {
                int parseInt = Integer.parseInt((String) list.get(0));
                String str = (String) list.get(1);
                if (type != 1) {
                    if (type != 2 || parseInt < maxCount) {
                        return true;
                    }
                    return false;
                }
                if (!Intrinsics.areEqual(str, H9(System.currentTimeMillis())) || parseInt < maxCount) {
                    return true;
                }
                return false;
            }
            QLog.e("QQSearch.NetDetail.SearchAnimPart", 1, "[canShowAnim] err, countInfo: " + ((Object) string));
        }
        return true;
    }

    private final void I9(final String url, final IPreloadService.c listener) {
        final IPreloadService iPreloadService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iPreloadService = (IPreloadService) peekAppRuntime.getRuntimeService(IPreloadService.class, "all")) != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.g
                @Override // java.lang.Runnable
                public final void run() {
                    SearchAnimPart.J9(IPreloadService.this, url, listener);
                }
            }, 64, null, false);
        } else {
            listener.onResult(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(IPreloadService it, String str, IPreloadService.c listener) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        it.getUnzipFolderPath(str, listener);
    }

    private final ISearchPopService K9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (ISearchPopService) peekAppRuntime.getRuntimeService(ISearchPopService.class, "all");
        }
        return null;
    }

    private final void L9(View rootView, Context context) {
        Integer num;
        Integer num2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mAnimRoot = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout relativeLayout2 = this.mAnimRoot;
        if (relativeLayout2 != null) {
            relativeLayout2.setLayoutParams(new ConstraintLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 300.0f, context.getResources().getDisplayMetrics())));
        }
        LottieAnimationView lottieAnimationView = this.mLottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        LottieAnimationView lottieAnimationView2 = this.mLottieView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setBackgroundColor(0);
        }
        RelativeLayout relativeLayout3 = this.mAnimRoot;
        if (relativeLayout3 != null) {
            relativeLayout3.addView(this.mLottieView);
        }
        if (this.mCloseView == null) {
            this.mCloseView = new ImageView(context);
        }
        ImageView imageView = this.mCloseView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.guild_member_search_box_close);
        }
        int applyDimension = (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
        ImageView imageView2 = this.mCloseView;
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            imageView2.setLayoutParams(layoutParams);
        }
        ImageView imageView3 = this.mCloseView;
        Integer num3 = null;
        if (imageView3 != null) {
            int applyDimension2 = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
            ViewGroup.LayoutParams layoutParams2 = imageView3.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams3 = imageView3.getLayoutParams();
                int i16 = -2;
                if (layoutParams3 != null) {
                    i3 = layoutParams3.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams4 = imageView3.getLayoutParams();
                if (layoutParams4 != null) {
                    i16 = layoutParams4.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
            }
            if (applyDimension2 != marginLayoutParams.rightMargin) {
                marginLayoutParams.rightMargin = applyDimension2;
                imageView3.setLayoutParams(marginLayoutParams);
            }
        }
        ImageView imageView4 = this.mCloseView;
        if (imageView4 != null) {
            imageView4.setId(View.generateViewId());
        }
        ImageView imageView5 = this.mCloseView;
        if (imageView5 != null) {
            imageView5.setOnClickListener(this);
        }
        RelativeLayout relativeLayout4 = this.mAnimRoot;
        if (relativeLayout4 != null) {
            relativeLayout4.addView(this.mCloseView);
        }
        if (rootView instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            constraintLayout.addView(this.mAnimRoot);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            RelativeLayout relativeLayout5 = this.mAnimRoot;
            if (relativeLayout5 != null) {
                num = Integer.valueOf(relativeLayout5.getId());
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            constraintSet.connect(num.intValue(), 4, 0, 4);
            RelativeLayout relativeLayout6 = this.mAnimRoot;
            if (relativeLayout6 != null) {
                num2 = Integer.valueOf(relativeLayout6.getId());
            } else {
                num2 = null;
            }
            Intrinsics.checkNotNull(num2);
            constraintSet.connect(num2.intValue(), 6, 0, 6);
            RelativeLayout relativeLayout7 = this.mAnimRoot;
            if (relativeLayout7 != null) {
                num3 = Integer.valueOf(relativeLayout7.getId());
            }
            Intrinsics.checkNotNull(num3);
            constraintSet.connect(num3.intValue(), 7, 0, 7);
            constraintSet.applyTo(constraintLayout);
        }
        RelativeLayout relativeLayout8 = this.mAnimRoot;
        if (relativeLayout8 != null) {
            relativeLayout8.setVisibility(8);
        }
        RelativeLayout relativeLayout9 = this.mAnimRoot;
        if (relativeLayout9 != null) {
            relativeLayout9.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(final SearchAnimPart this$0, final he1.a it, final String keyword, int i3, final IPreloadService.PathResult pathResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(keyword, "$keyword");
        QLog.i("QQSearch.NetDetail.SearchAnimPart", 1, "getPreloadZipResLocalPath ret:" + i3 + " data:" + pathResult);
        if (i3 == 0 && !TextUtils.isEmpty(pathResult.folderPath)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.h
                @Override // java.lang.Runnable
                public final void run() {
                    SearchAnimPart.O9(SearchAnimPart.this, pathResult, it, keyword);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(SearchAnimPart this$0, IPreloadService.PathResult pathResult, he1.a it, String keyword) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(keyword, "$keyword");
        String str = pathResult.folderPath;
        Intrinsics.checkNotNullExpressionValue(str, "pathResult.folderPath");
        this$0.Q9(str, it, keyword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(Reason reason) {
        String str;
        String str2;
        String str3;
        String str4;
        Float f16;
        if (this.mIsDestroyed) {
            return;
        }
        try {
            if ((getPartRootView() instanceof ViewGroup) && this.mAnimRoot != null) {
                View partRootView = getPartRootView();
                Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) partRootView).removeView(this.mAnimRoot);
                if (reason != Reason.NONE) {
                    WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("989435").setOperModule("9706").setOpertype("18").setExt(4, "18").setExt(1, "970602");
                    he1.a aVar = this.mCurrentData;
                    if (aVar != null) {
                        str = aVar.f404789c;
                    } else {
                        str = null;
                    }
                    WadlReportBuilder ext2 = ext.setExt(2, str);
                    he1.a aVar2 = this.mCurrentData;
                    if (aVar2 != null) {
                        str2 = aVar2.f404790d;
                    } else {
                        str2 = null;
                    }
                    WadlReportBuilder ext3 = ext2.setExt(6, str2).setExt(9, String.valueOf(reason.ordinal()));
                    he1.a aVar3 = this.mCurrentData;
                    if (aVar3 != null) {
                        str3 = aVar3.f404797k;
                    } else {
                        str3 = null;
                    }
                    WadlReportBuilder gameAppId = ext3.setGameAppId(str3);
                    he1.a aVar4 = this.mCurrentData;
                    if (aVar4 != null) {
                        str4 = aVar4.f404796j;
                    } else {
                        str4 = null;
                    }
                    WadlReportBuilder ext4 = gameAppId.setExt(29, str4).setExt(11, "1").setExt(12, "9520");
                    LottieAnimationView lottieAnimationView = this.mLottieView;
                    if (lottieAnimationView != null) {
                        f16 = Float.valueOf(lottieAnimationView.getProgress());
                    } else {
                        f16 = null;
                    }
                    ext4.setExt(38, String.valueOf(f16)).setExt(46, String.valueOf(System.currentTimeMillis() - this.mAnimStartTime)).report();
                }
            }
        } catch (Exception e16) {
            QLog.e("QQSearch.NetDetail.SearchAnimPart", 1, e16, new Object[0]);
        }
        this.mAnimRoot = null;
        this.mLottieView = null;
        this.mCloseView = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.content.Context, T] */
    private final void Q9(String resfolder, final he1.a data, String keyword) {
        QLog.d("QQSearch.NetDetail.SearchAnimPart", 1, "showAnimView res: " + resfolder + ", url:" + data.f404788b + " destroyed:" + this.mIsDestroyed);
        if (this.mIsDestroyed) {
            return;
        }
        this.mCurrentData = data;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            try {
                P9(Reason.NONE);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = partRootView.getContext();
                if (this.mLottieView == null) {
                    this.mLottieView = new LottieAnimationView((Context) objectRef.element);
                }
                String str = File.separator;
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = new FileInputStream(resfolder + str + "default.json");
                final String str2 = resfolder + str + "images";
                LottieAnimationView lottieAnimationView = this.mLottieView;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.search.searchdetail.i
                        @Override // com.airbnb.lottie.ImageAssetDelegate
                        public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                            Bitmap T9;
                            T9 = SearchAnimPart.T9(str2, lottieImageAsset);
                            return T9;
                        }
                    });
                }
                LottieComposition.Factory.fromInputStream((InputStream) objectRef2.element, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.search.searchdetail.j
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        SearchAnimPart.R9(SearchAnimPart.this, objectRef, data, objectRef2, lottieComposition);
                    }
                });
            } catch (Exception e16) {
                QLog.e("QQSearch.NetDetail.SearchAnimPart", 1, "[showAnimView] err: " + e16);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void R9(final SearchAnimPart this$0, Ref.ObjectRef context, final he1.a data, Ref.ObjectRef fis, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(fis, "$fis");
        if (lottieComposition == null || this$0.mLottieView == null) {
            return;
        }
        View rootView = this$0.getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        T context2 = context.element;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this$0.L9(rootView, (Context) context2);
        LottieAnimationView lottieAnimationView = this$0.mLottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setComposition(lottieComposition);
        }
        LottieAnimationView lottieAnimationView2 = this$0.mLottieView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.addAnimatorListener(new b());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.k
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimPart.S9(SearchAnimPart.this, data);
            }
        }, 16, null, false);
        this$0.mAnimStartTime = System.currentTimeMillis();
        RelativeLayout relativeLayout = this$0.mAnimRoot;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView3 = this$0.mLottieView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.playAnimation();
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("989432").setOperModule("9706").setOpertype("8").setExt(4, "8").setExt(1, "970602").setExt(2, data.f404789c).setExt(6, data.f404790d).setGameAppId(data.f404797k).setExt(29, data.f404796j).setExt(11, "1").setExt(12, "9520").report();
        try {
            ((FileInputStream) fis.element).close();
        } catch (Exception e16) {
            QLog.e("QQSearch.NetDetail.SearchAnimPart", 1, "[showAnimView] ani err: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(SearchAnimPart this$0, he1.a data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.F9(data.f404787a, data.f404791e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap T9(String imgsPath, LottieImageAsset lottieImageAsset) {
        Intrinsics.checkNotNullParameter(imgsPath, "$imgsPath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        try {
            return BitmapFactory.decodeFile(imgsPath + File.separator + lottieImageAsset.getFileName(), options);
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final String H9(long timestamp) {
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date(timestamp));
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(date)");
        return format;
    }

    public final void M9(@NotNull final String keyword) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        boolean z16;
        final he1.a aVar;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Object broadcastGetMessage = broadcastGetMessage("getTabInfo", null);
        if (broadcastGetMessage instanceof SearchDetailTabListViewModel.TabInfo) {
            tabInfo = (SearchDetailTabListViewModel.TabInfo) broadcastGetMessage;
        } else {
            tabInfo = null;
        }
        if (tabInfo != null && ((int) tabInfo.getTabMask()) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ISearchPopService K9 = K9();
            if (K9 != null) {
                aVar = K9.getSearchPopAnimationData(keyword);
            } else {
                aVar = null;
            }
            QLog.d("QQSearch.NetDetail.SearchAnimPart", 1, "[onSearchSucc] keyword:" + ag.b(keyword, 0, 1, null) + " data:" + ag.b(String.valueOf(aVar), 0, 1, null));
            if (aVar != null) {
                if (!G9(aVar.f404787a, aVar.f404791e, aVar.f404792f)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQSearch.NetDetail.SearchAnimPart", 1, "[onSearchSucc] reach limit, not show");
                    }
                } else {
                    I9(aVar.f404790d, new IPreloadService.c() { // from class: com.tencent.mobileqq.search.searchdetail.f
                        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
                        public final void onResult(int i3, IPreloadService.PathResult pathResult) {
                            SearchAnimPart.N9(SearchAnimPart.this, aVar, keyword, i3, pathResult);
                        }
                    });
                    new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("989430").setOperModule("9705").setOpertype("7").setExt(4, "7").setExt(1, "970501").setExt(2, aVar.f404789c).setExt(6, aVar.f404790d).setGameAppId(aVar.f404797k).setExt(29, aVar.f404796j).setExt(11, "1").setExt(12, "9520").report();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "startSearch")) {
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchAnimPart", 1, "MESSAGE_START_SEARCH");
            P9(Reason.SERACH);
        } else if (Intrinsics.areEqual(action, "MESSAGE_SHOW_SEARCH_FRAME")) {
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchAnimPart", 1, "MESSAGE_SHOW_SEARCH_FRAME");
            P9(Reason.SERACH);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010a  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@Nullable View view) {
        Integer num;
        Integer num2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z16;
        he1.a aVar;
        String str7;
        String str8;
        String str9;
        boolean startsWith$default;
        String str10;
        boolean startsWith$default2;
        String str11;
        String str12;
        String str13;
        String str14;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        ImageView imageView = this.mCloseView;
        if (imageView != null) {
            num2 = Integer.valueOf(imageView.getId());
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            LottieAnimationView lottieAnimationView = this.mLottieView;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            P9(Reason.CLOSE);
            WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("989434").setOperModule("9706").setOpertype("20").setExt(4, "20").setExt(1, "970602");
            he1.a aVar2 = this.mCurrentData;
            if (aVar2 != null) {
                str11 = aVar2.f404789c;
            } else {
                str11 = null;
            }
            WadlReportBuilder ext2 = ext.setExt(2, str11);
            he1.a aVar3 = this.mCurrentData;
            if (aVar3 != null) {
                str12 = aVar3.f404790d;
            } else {
                str12 = null;
            }
            WadlReportBuilder ext3 = ext2.setExt(6, str12);
            he1.a aVar4 = this.mCurrentData;
            if (aVar4 != null) {
                str13 = aVar4.f404797k;
            } else {
                str13 = null;
            }
            WadlReportBuilder gameAppId = ext3.setGameAppId(str13);
            he1.a aVar5 = this.mCurrentData;
            if (aVar5 != null) {
                str14 = aVar5.f404796j;
            } else {
                str14 = null;
            }
            gameAppId.setExt(29, str14).setExt(11, "1").setExt(12, "9520").report();
        } else {
            he1.a aVar6 = this.mCurrentData;
            if (aVar6 != null) {
                str = aVar6.f404788b;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                he1.a aVar7 = this.mCurrentData;
                boolean z17 = false;
                if (aVar7 != null && (str10 = aVar7.f404788b) != null) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str10, "http://", false, 2, null);
                    if (startsWith$default2) {
                        z16 = true;
                        if (z16) {
                            he1.a aVar8 = this.mCurrentData;
                            if (aVar8 != null && (str9 = aVar8.f404788b) != null) {
                                str2 = null;
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str9, "https://", false, 2, null);
                                if (startsWith$default) {
                                    z17 = true;
                                }
                            } else {
                                str2 = null;
                            }
                            if (!z17) {
                                he1.a aVar9 = this.mCurrentData;
                                if (aVar9 != null) {
                                    str8 = aVar9.f404788b;
                                } else {
                                    str8 = str2;
                                }
                                getActivity().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str8)));
                            }
                        } else {
                            str2 = null;
                        }
                        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
                        aVar = this.mCurrentData;
                        if (aVar == null) {
                            str7 = aVar.f404788b;
                        } else {
                            str7 = str2;
                        }
                        intent.putExtra("url", str7);
                        getActivity().startActivity(intent);
                    }
                }
                z16 = false;
                if (z16) {
                }
                Intent intent2 = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
                aVar = this.mCurrentData;
                if (aVar == null) {
                }
                intent2.putExtra("url", str7);
                getActivity().startActivity(intent2);
            } else {
                str2 = null;
            }
            LottieAnimationView lottieAnimationView2 = this.mLottieView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.cancelAnimation();
            }
            P9(Reason.CLICK);
            WadlReportBuilder ext4 = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("989433").setOperModule("9706").setOpertype("20").setExt(4, "20").setExt(1, "970602");
            he1.a aVar10 = this.mCurrentData;
            if (aVar10 != null) {
                str3 = aVar10.f404789c;
            } else {
                str3 = str2;
            }
            WadlReportBuilder ext5 = ext4.setExt(2, str3);
            he1.a aVar11 = this.mCurrentData;
            if (aVar11 != null) {
                str4 = aVar11.f404790d;
            } else {
                str4 = str2;
            }
            WadlReportBuilder ext6 = ext5.setExt(6, str4);
            he1.a aVar12 = this.mCurrentData;
            if (aVar12 != null) {
                str5 = aVar12.f404797k;
            } else {
                str5 = str2;
            }
            WadlReportBuilder gameAppId2 = ext6.setGameAppId(str5);
            he1.a aVar13 = this.mCurrentData;
            if (aVar13 != null) {
                str6 = aVar13.f404796j;
            } else {
                str6 = str2;
            }
            gameAppId2.setExt(29, str6).setExt(11, "1").setExt(12, "9520").report();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ISearchPopService K9 = K9();
        if (K9 != null) {
            K9.onEnterSearch();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        ISearchPopService K9 = K9();
        if (K9 != null) {
            K9.onExitSearch();
        }
        LottieAnimationView lottieAnimationView = this.mLottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        P9(Reason.RETURN);
        this.mIsDestroyed = true;
    }
}

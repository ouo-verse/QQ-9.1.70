package com.qzone.reborn.groupalbum.part;

import aa.f;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.albumx.common.bean.CommonTransmitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager;
import com.qzone.reborn.groupalbum.viewmodel.an;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001hB+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\be\u0010fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0003J\u0012\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010!\u001a\u00020\u00062\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u001c\u0010&\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010)\u001a\u00020(H\u0016R\u0016\u0010,\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00101\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR#\u0010H\u001a\n D*\u0004\u0018\u00010C0C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010?\u001a\u0004\bF\u0010GR\"\u0010O\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010W\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010[\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010R\u001a\u0004\bY\u0010T\"\u0004\bZ\u0010VR\u0014\u0010]\u001a\u00020(8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\\\u0010+R\u0014\u0010^\u001a\u00020(8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bJ\u0010+R\u0014\u0010`\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b_\u0010JR\u0014\u0010b\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\ba\u0010JR\u0016\u0010d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010J\u00a8\u0006i"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/GroupAlbumTransmitPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "Lcom/qzone/reborn/groupalbum/reship/manager/b;", "", "resId", "", "X9", "colorFilterId", "Landroid/graphics/drawable/Drawable;", "drawable", "W9", "M9", "initData", "Y9", "", "showTypeIsDownload", "K9", "allSize", "J9", "V9", "showAnim", "U9", "T9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskStateData", "onStateChange", "", "Lcom/qzone/publish/business/task/IQueueTask;", Constants.Raft.TASKS, "H5", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", mqq.app.Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "getLogTag", "d", "Ljava/lang/String;", "groupId", "e", "albumId", "f", "Ljava/lang/Integer;", "lottieSize", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mIvTransmitQueenView", "i", "Landroid/view/View;", "mIvTransmitQueenRoot", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mPublishBoxTaskNum", "Lcom/qzone/reborn/groupalbum/viewmodel/an;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "L9", "()Lcom/qzone/reborn/groupalbum/viewmodel/an;", "publishQueueVm", "Lcom/qzone/reborn/albumx/common/viewmodel/m;", "kotlin.jvm.PlatformType", "D", "N9", "()Lcom/qzone/reborn/albumx/common/viewmodel/m;", "transmitVm", "E", "I", "getMCurrentShowStatus", "()I", "setMCurrentShowStatus", "(I)V", "mCurrentShowStatus", "Lcom/airbnb/lottie/LottieDrawable;", UserInfo.SEX_FEMALE, "Lcom/airbnb/lottie/LottieDrawable;", "getMPublishAnimation", "()Lcom/airbnb/lottie/LottieDrawable;", "setMPublishAnimation", "(Lcom/airbnb/lottie/LottieDrawable;)V", "mPublishAnimation", "G", "getMDownloadAnimation", "setMDownloadAnimation", "mDownloadAnimation", "H", "UPLOAD_LOTTIE_ANIMATION_FILENAME", "DOWNLOAD_LOTTIE_ANIMATION_FILENAME", "J", "LOTTIE_ANIMATION_W", "K", "LOTTIE_ANIMATION_H", "L", "lottieFilterColorId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumTransmitPart extends com.qzone.reborn.base.k implements RFWDownloadQueueResultListener, com.qzone.reborn.groupalbum.reship.manager.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy publishQueueVm;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy transmitVm;

    /* renamed from: E, reason: from kotlin metadata */
    private int mCurrentShowStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private LottieDrawable mPublishAnimation;

    /* renamed from: G, reason: from kotlin metadata */
    private LottieDrawable mDownloadAnimation;

    /* renamed from: H, reason: from kotlin metadata */
    private final String UPLOAD_LOTTIE_ANIMATION_FILENAME;

    /* renamed from: I, reason: from kotlin metadata */
    private final String DOWNLOAD_LOTTIE_ANIMATION_FILENAME;

    /* renamed from: J, reason: from kotlin metadata */
    private final int LOTTIE_ANIMATION_W;

    /* renamed from: K, reason: from kotlin metadata */
    private final int LOTTIE_ANIMATION_H;

    /* renamed from: L, reason: from kotlin metadata */
    private int lottieFilterColorId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String groupId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String albumId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Integer lottieSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvTransmitQueenView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mIvTransmitQueenRoot;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mPublishBoxTaskNum;

    public GroupAlbumTransmitPart(String str, String str2, Integer num) {
        Lazy lazy;
        Lazy lazy2;
        this.groupId = str;
        this.albumId = str2;
        this.lottieSize = num;
        RFWLog.i("GroupAlbumTransmitPart", RFWLog.USR, "init, groupId:" + str + ", albumId:" + str2);
        if (str == null || str.length() == 0) {
            RFWLog.fatal("GroupAlbumTransmitPart", RFWLog.USR, new RuntimeException("groupId should not be null or empty"));
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<an>() { // from class: com.qzone.reborn.groupalbum.part.GroupAlbumTransmitPart$publishQueueVm$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final an invoke() {
                return new an();
            }
        });
        this.publishQueueVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.albumx.common.viewmodel.m>() { // from class: com.qzone.reborn.groupalbum.part.GroupAlbumTransmitPart$transmitVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.albumx.common.viewmodel.m invoke() {
                return (com.qzone.reborn.albumx.common.viewmodel.m) GroupAlbumTransmitPart.this.getViewModel(com.qzone.reborn.albumx.common.viewmodel.m.class);
            }
        });
        this.transmitVm = lazy2;
        this.UPLOAD_LOTTIE_ANIMATION_FILENAME = "group_album/upload_lottie_animation.json";
        this.DOWNLOAD_LOTTIE_ANIMATION_FILENAME = "group_album/download_lottie_animation.json";
        this.LOTTIE_ANIMATION_W = 24;
        this.LOTTIE_ANIMATION_H = 24;
        this.lottieFilterColorId = R.color.qui_common_icon_nav_secondary;
    }

    private final void J9(boolean showTypeIsDownload, int allSize) {
        String valueOf;
        View view = this.mIvTransmitQueenRoot;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        view.setVisibility(0);
        if (showTypeIsDownload) {
            T9(true);
        } else {
            U9(true);
        }
        if (allSize > 99) {
            valueOf = 99 + Marker.ANY_NON_NULL_MARKER;
        } else {
            valueOf = String.valueOf(allSize);
        }
        TextView textView2 = this.mPublishBoxTaskNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            textView2 = null;
        }
        textView2.setText(valueOf);
        TextView textView3 = this.mPublishBoxTaskNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
        } else {
            textView = textView3;
        }
        textView.setBackgroundResource(R.drawable.f170675);
    }

    private final void K9(boolean showTypeIsDownload) {
        View view = this.mIvTransmitQueenRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view = null;
        }
        view.setVisibility(0);
        if (showTypeIsDownload) {
            T9(false);
        } else {
            U9(false);
        }
    }

    private final an L9() {
        return (an) this.publishQueueVm.getValue();
    }

    private final int M9() {
        int i3 = this.mCurrentShowStatus;
        if (i3 != 2) {
            return i3 != 3 ? 0 : 2;
        }
        return 1;
    }

    private final com.qzone.reborn.albumx.common.viewmodel.m N9() {
        return (com.qzone.reborn.albumx.common.viewmodel.m) this.transmitVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(GroupAlbumTransmitPart this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieDrawable lottieDrawable2 = this$0.mPublishAnimation;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            lottieDrawable2.stop();
            lottieDrawable2.removeAllAnimatorListeners();
        }
        this$0.mPublishAnimation = lottieDrawable;
        this$0.W9(this$0.lottieFilterColorId, lottieDrawable);
        if (this$0.mPublishAnimation == null || this$0.mDownloadAnimation == null) {
            return;
        }
        this$0.Y9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(GroupAlbumTransmitPart this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieDrawable lottieDrawable2 = this$0.mDownloadAnimation;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            lottieDrawable2.stop();
            lottieDrawable2.removeAllAnimatorListeners();
        }
        this$0.mDownloadAnimation = lottieDrawable;
        this$0.W9(this$0.lottieFilterColorId, lottieDrawable);
        if (this$0.mPublishAnimation == null || this$0.mDownloadAnimation == null) {
            return;
        }
        this$0.Y9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(GroupAlbumTransmitPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.d("GroupAlbumTransmitPart", RFWLog.USR, "user click publish queen view");
        String str = this$0.groupId;
        if (str != null) {
            GroupAlbumReshipSendBoxManager.f56848a.w(str);
        }
        oi.c m3 = ho.i.m();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str2 = this$0.groupId;
        if (str2 == null) {
            str2 = "";
        }
        m3.m(context, new GroupAlbumTaskDetailInitBean(str2, this$0.albumId, Integer.valueOf(this$0.M9())));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        LottieDrawable lottieDrawable = this.mPublishAnimation;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
        }
        LottieDrawable lottieDrawable2 = this.mDownloadAnimation;
        if (lottieDrawable2 != null) {
            lottieDrawable2.stop();
        }
    }

    private final void W9(int colorFilterId, Drawable drawable) {
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(getPartRootView().getResources().getColor(colorFilterId, null), PorterDuff.Mode.SRC_ATOP);
        KeyPath keyPath = new KeyPath("**");
        LottieValueCallback lottieValueCallback = new LottieValueCallback(porterDuffColorFilter);
        if (drawable != null && (drawable instanceof LottieDrawable)) {
            ((LottieDrawable) drawable).addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) lottieValueCallback);
        } else if (drawable != null) {
            drawable.setColorFilter(getContext().getResources().getColor(colorFilterId), PorterDuff.Mode.SRC_ATOP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(int resId) {
        this.lottieFilterColorId = resId;
        W9(resId, this.mPublishAnimation);
        W9(this.lottieFilterColorId, this.mDownloadAnimation);
    }

    private final void initData() {
        String str = this.groupId;
        if (str != null) {
            GroupAlbumReshipSendBoxManager.f56848a.i(str, this);
        }
        String str2 = this.groupId;
        if (str2 != null) {
            GroupAlbumReshipSendBoxManager.f56848a.w(str2);
        }
        an L9 = L9();
        String str3 = this.groupId;
        if (str3 == null) {
            str3 = "";
        }
        L9.S1(str3, L9.getAlbumId());
        LiveData<CommonTransmitBean> R1 = L9.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonTransmitBean, Unit> function1 = new Function1<CommonTransmitBean, Unit>() { // from class: com.qzone.reborn.groupalbum.part.GroupAlbumTransmitPart$initData$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonTransmitBean commonTransmitBean) {
                invoke2(commonTransmitBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonTransmitBean commonTransmitBean) {
                GroupAlbumTransmitPart.this.Y9();
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumTransmitPart.O9(Function1.this, obj);
            }
        });
        Y9();
    }

    @Override // com.qzone.reborn.groupalbum.reship.manager.b
    public void H5(List<IQueueTask> tasks) {
        Y9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumTransmitPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        zh.b.l().r(this.groupId, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        L9().onCleared();
        zh.b.l().s(this.groupId, this);
        V9();
    }

    private final void T9(boolean showAnim) {
        ImageView imageView = null;
        if (showAnim) {
            LottieDrawable lottieDrawable = this.mDownloadAnimation;
            if (lottieDrawable == null || lottieDrawable.isRunning()) {
                return;
            }
            ImageView imageView2 = this.mIvTransmitQueenView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(lottieDrawable);
            lottieDrawable.start();
            return;
        }
        LottieDrawable lottieDrawable2 = this.mDownloadAnimation;
        if (lottieDrawable2 != null) {
            lottieDrawable2.setFrame((int) lottieDrawable2.getMaxFrame());
            ImageView imageView3 = this.mIvTransmitQueenView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(lottieDrawable2);
        }
    }

    private final void U9(boolean showAnim) {
        ImageView imageView = null;
        if (showAnim) {
            LottieDrawable lottieDrawable = this.mPublishAnimation;
            if (lottieDrawable == null || lottieDrawable.isRunning()) {
                return;
            }
            ImageView imageView2 = this.mIvTransmitQueenView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(lottieDrawable);
            lottieDrawable.start();
            return;
        }
        LottieDrawable lottieDrawable2 = this.mPublishAnimation;
        if (lottieDrawable2 != null) {
            lottieDrawable2.setFrame((int) lottieDrawable2.getMaxFrame());
            ImageView imageView3 = this.mIvTransmitQueenView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(lottieDrawable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        boolean z16;
        long h16 = zh.b.l().h(this.groupId);
        boolean j3 = zh.b.l().j(this.groupId);
        boolean k3 = zh.b.l().k(this.groupId);
        int g16 = zh.b.l().g(this.groupId);
        CommonTransmitBean value = L9().R1().getValue();
        boolean hasRunningTask = value != null ? value.getHasRunningTask() : false;
        CommonTransmitBean value2 = L9().R1().getValue();
        boolean hasWaitRunningTask = value2 != null ? value2.getHasWaitRunningTask() : false;
        CommonTransmitBean value3 = L9().R1().getValue();
        long lastBeginTime = value3 != null ? value3.getLastBeginTime() : 0L;
        CommonTransmitBean value4 = L9().R1().getValue();
        int taskSize = value4 != null ? value4.getTaskSize() : 0;
        GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = GroupAlbumReshipSendBoxManager.f56848a;
        String str = this.groupId;
        if (str == null) {
            str = "";
        }
        int m3 = groupAlbumReshipSendBoxManager.m(str);
        String str2 = this.groupId;
        if (str2 == null) {
            str2 = "";
        }
        boolean z17 = m3 - groupAlbumReshipSendBoxManager.l(str2) > 0;
        int i3 = g16 + taskSize + m3;
        if (i3 <= 0) {
            this.mCurrentShowStatus = 0;
            View view = this.mIvTransmitQueenRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
                view = null;
            }
            view.setVisibility(8);
            return;
        }
        boolean z18 = h16 > lastBeginTime;
        if (hasRunningTask || j3) {
            z16 = (z18 && j3) || !hasRunningTask;
            this.mCurrentShowStatus = z16 ? 2 : 1;
            J9(z16, i3);
            return;
        }
        if (hasWaitRunningTask || k3) {
            z16 = (z18 && k3) || !hasWaitRunningTask;
            this.mCurrentShowStatus = z16 ? 2 : 1;
            K9(z16);
            TextView textView = this.mPublishBoxTaskNum;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                textView = null;
            }
            textView.setText("");
            TextView textView2 = this.mPublishBoxTaskNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                textView2 = null;
            }
            textView2.setBackgroundResource(R.drawable.f17049p);
            return;
        }
        if (z17) {
            this.mCurrentShowStatus = 3;
            J9(false, i3);
            return;
        }
        View view2 = this.mIvTransmitQueenRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
            view2 = null;
        }
        view2.setVisibility(0);
        if (g16 > 0) {
            this.mCurrentShowStatus = 2;
            LottieDrawable lottieDrawable = this.mDownloadAnimation;
            if (lottieDrawable != null) {
                lottieDrawable.setFrame((int) lottieDrawable.getMaxFrame());
                ImageView imageView = this.mIvTransmitQueenView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                    imageView = null;
                }
                imageView.setImageDrawable(lottieDrawable);
                TextView textView3 = this.mPublishBoxTaskNum;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                    textView3 = null;
                }
                textView3.setBackgroundResource(R.drawable.f17059q);
            }
        } else if (taskSize > 0 || m3 > 0) {
            this.mCurrentShowStatus = taskSize > 0 ? 1 : 3;
            LottieDrawable lottieDrawable2 = this.mPublishAnimation;
            if (lottieDrawable2 != null) {
                lottieDrawable2.setFrame((int) lottieDrawable2.getMaxFrame());
                ImageView imageView2 = this.mIvTransmitQueenView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
                    imageView2 = null;
                }
                imageView2.setImageDrawable(lottieDrawable2);
                TextView textView4 = this.mPublishBoxTaskNum;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
                    textView4 = null;
                }
                textView4.setBackgroundResource(R.drawable.f17059q);
            }
        }
        V9();
        TextView textView5 = this.mPublishBoxTaskNum;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBoxTaskNum");
            textView5 = null;
        }
        textView5.setText("");
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData taskStateData) {
        if ((taskStateData != null ? taskStateData.getState() : null) != DownloadState.STATE_RUNNING) {
            Y9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        int i3;
        int i16;
        int i17;
        int i18;
        MutableLiveData<Integer> M1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.qzone.reborn.albumx.common.viewmodel.m N9 = N9();
        if (N9 != null && (M1 = N9.M1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.groupalbum.part.GroupAlbumTransmitPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    GroupAlbumTransmitPart groupAlbumTransmitPart = GroupAlbumTransmitPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    groupAlbumTransmitPart.X9(it.intValue());
                }
            };
            M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumTransmitPart.P9(Function1.this, obj);
                }
            });
        }
        Activity activity = getActivity();
        String str = this.UPLOAD_LOTTIE_ANIMATION_FILENAME;
        Integer num = this.lottieSize;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = this.LOTTIE_ANIMATION_W;
        }
        int i19 = i3;
        Integer num2 = this.lottieSize;
        if (num2 != null) {
            i16 = num2.intValue();
        } else {
            i16 = this.LOTTIE_ANIMATION_H;
        }
        LottieHelper.b(activity, str, null, i19, i16, -1, new LottieHelper.d() { // from class: com.qzone.reborn.groupalbum.part.z
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                GroupAlbumTransmitPart.Q9(GroupAlbumTransmitPart.this, lottieDrawable);
            }
        });
        Activity activity2 = getActivity();
        String str2 = this.DOWNLOAD_LOTTIE_ANIMATION_FILENAME;
        Integer num3 = this.lottieSize;
        if (num3 != null) {
            i17 = num3.intValue();
        } else {
            i17 = this.LOTTIE_ANIMATION_W;
        }
        int i26 = i17;
        Integer num4 = this.lottieSize;
        if (num4 != null) {
            i18 = num4.intValue();
        } else {
            i18 = this.LOTTIE_ANIMATION_H;
        }
        LottieHelper.b(activity2, str2, null, i26, i18, -1, new LottieHelper.d() { // from class: com.qzone.reborn.groupalbum.part.aa
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                GroupAlbumTransmitPart.R9(GroupAlbumTransmitPart.this, lottieDrawable);
            }
        });
        View findViewById = rootView.findViewById(R.id.n6a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026mate_title_transmit_view)");
        this.mIvTransmitQueenRoot = findViewById;
        View findViewById2 = rootView.findViewById(R.id.n69);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026itle_transmit_image_view)");
        this.mIvTransmitQueenView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.n6_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026title_transmit_text_view)");
        this.mPublishBoxTaskNum = (TextView) findViewById3;
        ImageView imageView = this.mIvTransmitQueenView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupAlbumTransmitPart.S9(GroupAlbumTransmitPart.this, view2);
            }
        });
        f.Companion companion = aa.f.INSTANCE;
        View view2 = this.mIvTransmitQueenRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvTransmitQueenRoot");
        } else {
            view = view2;
        }
        companion.a(view);
        initData();
    }
}

package com.tencent.biz.qrcode.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardButtonPart;
import com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart;
import com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardTitlePart;
import com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel;
import com.tencent.biz.qrcode.mgr.MyQRCodeManager;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 V2\u00020\u0001:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u0013\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J$\u0010(\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\"\u00101\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\u0010\u00105\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0016R2\u0010>\u001a\u0012\u0012\u0004\u0012\u00020406j\b\u0012\u0004\u0012\u000204`78\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010L\u001a\u00020E8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010S\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/QRDisplayMyCardFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initData", "Oh", "", "", "Gh", "", "Eh", "()Ljava/lang/Integer;", "Lcom/tencent/biz/qrcode/mgr/d;", "qrCodeData", "Rh", "Landroid/view/View;", "shareView", "maskView", "Lkotlin/Function0;", "startShot", "Qh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Nh", "Ch", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "newWidth", "newHeight", "Fh", "uin", "", "needAnimation", "Bh", "Ih", "setStatusBarImmersive", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onPostThemeChanged", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "getMParts", "()Ljava/util/ArrayList;", "setMParts", "(Ljava/util/ArrayList;)V", "mParts", "D", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Sh", "(Landroid/view/View;)V", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "E", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "Hh", "()Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "Th", "(Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;)V", "viewModel", UserInfo.SEX_FEMALE, "I", "Dh", "()I", "setCurStyle", "(I)V", "curStyle", "<init>", "()V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRDisplayMyCardFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Part> mParts = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    public View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    public QRDisplayMyCardViewModel viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int curStyle;

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(String uin, boolean needAnimation) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && h.x(qQAppInterface, uin) == 2) {
            Ih(needAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ch() {
        final Bitmap bitmap;
        com.tencent.biz.qrcode.mgr.d r16 = MyQRCodeManager.f94961a.r();
        if (r16 == null || (bitmap = r16.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String()) == null || bitmap.isRecycled()) {
            return;
        }
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        final View findViewById = getRootView().findViewById(R.id.f84214ln);
        Qh(findViewById, findViewById.findViewById(R.id.f648437b), new Function0<Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$generateAIGCShareBitmap$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Bitmap Fh;
                int width2 = findViewById.getWidth();
                int height2 = findViewById.getHeight();
                if (height2 != 0 && width2 != 0) {
                    Bitmap shareTopBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
                    findViewById.draw(new Canvas(shareTopBitmap));
                    int ceil = (int) Math.ceil((width / width2) * height2);
                    QRDisplayMyCardFragment qRDisplayMyCardFragment = this;
                    Intrinsics.checkNotNullExpressionValue(shareTopBitmap, "shareTopBitmap");
                    Fh = qRDisplayMyCardFragment.Fh(shareTopBitmap, width, ceil);
                    Bitmap createBitmap = Bitmap.createBitmap(width, height + ceil, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(Fh, 0.0f, 0.0f, (Paint) null);
                    canvas.drawBitmap(bitmap, 0.0f, ceil, (Paint) null);
                    this.Hh().r2().postValue(createBitmap);
                    return;
                }
                QLog.e("QRDisplayMyCardFragment", 1, "generateAIGCShareBitmap shareTopView invalid.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer Eh() {
        if (this.rootView == null) {
            return null;
        }
        return Integer.valueOf(getRootView().getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap Fh(Bitmap bitmap, int newWidth, int newHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width != 0 && height != 0) {
            Matrix matrix = new Matrix();
            matrix.postScale(newWidth / width, newHeight / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, \u2026th, height, matrix, true)");
            return createBitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> Gh() {
        String string;
        String string2;
        HashMap hashMap = new HashMap();
        hashMap.put("qq_pgid", "pg_my_qrcode");
        hashMap.put("qq_eid", "em_kl_add_friends_toast");
        int i3 = this.curStyle;
        String str = "";
        if (i3 == 2) {
            Bundle arguments = getArguments();
            if (arguments != null && (string2 = arguments.getString("my_qrcode_pg_source")) != null) {
                str = string2;
            }
            hashMap.put("my_qrcode_pg_source", str);
            hashMap.put("my_qrcode_pg_source_type", "3");
        } else if (i3 == 1) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null && (string = arguments2.getString("my_qrcode_pg_source")) != null) {
                str = string;
            }
            hashMap.put("my_qrcode_pg_source", str);
            hashMap.put("my_qrcode_pg_source_type", "1");
        }
        return hashMap;
    }

    private final void Ih(boolean needAnimation) {
        FragmentActivity activity;
        if (!com.tencent.biz.qrcode.util.f.a() && (activity = getActivity()) != null) {
            Intent intent = new Intent(activity, (Class<?>) QRDisplayActivity.class);
            intent.putExtras(activity.getIntent());
            if (!needAnimation) {
                activity.overridePendingTransition(0, 0);
            }
            activity.startActivity(intent);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            if (!needAnimation) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Nh(View rootView) {
        TextView textView;
        if (rootView == null) {
            QLog.e("QRDisplayMyCardFragment", 1, "initShareView, rootView is null");
            return;
        }
        String curUin = Hh().getCurUin();
        if (curUin != null) {
            ((QQProAvatarView) rootView.findViewById(R.id.f6477375)).x(1, curUin, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(curUin)).g(200).a());
            TextView textView2 = (TextView) rootView.findViewById(R.id.f649137i);
            if (textView2 != null) {
                textView2.setText(curUin);
            }
        }
        String curName = Hh().getCurName();
        if (curName != null && (textView = (TextView) rootView.findViewById(R.id.f648537c)) != null) {
            textView.setText(curName);
        }
    }

    private final void Oh() {
        MutableLiveData<QRDisplayMyCardViewModel.NewFriendToastMessage> t26 = Hh().t2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final QRDisplayMyCardFragment$initToast$1 qRDisplayMyCardFragment$initToast$1 = new QRDisplayMyCardFragment$initToast$1(this);
        t26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.biz.qrcode.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayMyCardFragment.Ph(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(final View shareView, final View maskView, final Function0<Unit> startShot) {
        ImageView imageView;
        if (shareView != null) {
            imageView = (ImageView) shareView.findViewById(R.id.f648737e);
        } else {
            imageView = null;
        }
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.oha, R.color.qui_common_icon_primary, 1000);
        if (imageView != null) {
            imageView.setImageDrawable(o16);
        }
        if (!QQTheme.isVasTheme()) {
            Context context = getContext();
            if (context != null) {
                int color = context.getColor(R.color.qui_common_fill_light_secondary);
                if (shareView != null) {
                    shareView.setBackgroundColor(color);
                }
                if (maskView != null) {
                    maskView.setVisibility(8);
                }
                if (maskView != null) {
                    maskView.setBackgroundColor(0);
                }
                startShot.invoke();
                return;
            }
            return;
        }
        final Context context2 = getContext();
        if (context2 != null) {
            Hh().A2(context2, new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$refreshShareCard$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    int u26 = QRDisplayMyCardFragment.this.Hh().u2(z16);
                    View view = shareView;
                    if (view != null) {
                        view.setBackgroundColor(context2.getColor(R.color.qui_common_bg_bottom_standard));
                    }
                    View view2 = maskView;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    View view3 = maskView;
                    if (view3 != null) {
                        view3.setBackgroundColor(u26);
                    }
                    startShot.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(com.tencent.biz.qrcode.mgr.d qrCodeData) {
        QLog.i("QRDisplayMyCardFragment", 1, "reportCurStyle : " + qrCodeData.getStyle());
        if (this.curStyle == qrCodeData.getStyle()) {
            return;
        }
        int style = qrCodeData.getStyle();
        this.curStyle = style;
        QLog.i("QRDisplayMyCardFragment", 1, "update DT pageParam curStyle: " + style);
        int i3 = this.curStyle;
        String str = null;
        if (i3 == 2) {
            com.tencent.biz.qrcode.util.a aVar = com.tencent.biz.qrcode.util.a.f95053a;
            View rootView = getRootView();
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString("my_qrcode_pg_source");
            }
            aVar.a(rootView, str, "3");
            return;
        }
        if (i3 == 1) {
            com.tencent.biz.qrcode.util.a aVar2 = com.tencent.biz.qrcode.util.a.f95053a;
            View rootView2 = getRootView();
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("my_qrcode_pg_source");
            }
            aVar2.a(rootView2, str, "1");
        }
    }

    private final void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("nick");
            if (string != null) {
                Hh().N2(string);
            }
            String string2 = arguments.getString("uin");
            if (string2 != null) {
                Hh().O2(string2);
            }
            String it = arguments.getString("from");
            if (it != null) {
                QRDisplayMyCardViewModel Hh = Hh();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Hh.P2(it);
            }
            Hh().Q2(arguments.getInt("reportFlag", 0));
        }
        String curUin = Hh().getCurUin();
        if (curUin != null) {
            Bh(curUin, true);
        }
        MutableLiveData<Boolean> o26 = Hh().o2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean needToChangeToQID) {
                Intrinsics.checkNotNullExpressionValue(needToChangeToQID, "needToChangeToQID");
                if (needToChangeToQID.booleanValue()) {
                    QRDisplayMyCardFragment.this.Hh().o2().postValue(Boolean.FALSE);
                    String curUin2 = QRDisplayMyCardFragment.this.Hh().getCurUin();
                    if (curUin2 != null) {
                        QRDisplayMyCardFragment.this.Bh(curUin2, false);
                    }
                }
            }
        };
        o26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.biz.qrcode.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayMyCardFragment.Kh(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> q26 = Hh().q2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it5) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (it5.booleanValue()) {
                    if (QRDisplayMyCardFragment.this.getCurStyle() == 1) {
                        QRDisplayMyCardFragment.this.Hh().h2().postValue(Boolean.TRUE);
                    } else if (QRDisplayMyCardFragment.this.getCurStyle() == 2) {
                        QRDisplayMyCardFragment.this.Ch();
                    }
                }
            }
        };
        q26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.biz.qrcode.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayMyCardFragment.Lh(Function1.this, obj);
            }
        });
        MutableLiveData<Bitmap> g26 = Hh().g2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Bitmap, Unit> function13 = new Function1<Bitmap, Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    final QRDisplayMyCardFragment qRDisplayMyCardFragment = QRDisplayMyCardFragment.this;
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    final View findViewById = qRDisplayMyCardFragment.getRootView().findViewById(R.id.f84374m3);
                    View findViewById2 = findViewById.findViewById(R.id.f648437b);
                    final ImageView imageView = (ImageView) findViewById.findViewById(R.id.f6481379);
                    imageView.setImageBitmap(bitmap);
                    qRDisplayMyCardFragment.Qh(findViewById, findViewById2, new Function0<Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$initData$5$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.ARGB_8888);
                            findViewById.draw(new Canvas(createBitmap));
                            qRDisplayMyCardFragment.Hh().r2().postValue(createBitmap);
                            QLog.i("QRDisplayMyCardFragment", 1, "update shareCache " + createBitmap.hashCode());
                        }
                    });
                }
            }
        };
        g26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.biz.qrcode.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayMyCardFragment.Mh(Function1.this, obj);
            }
        });
        Hh().E2();
        QLog.i("QRDisplayMyCardFragment", 1, "qrCodeData = " + Hh().p2().getValue());
        com.tencent.biz.qrcode.mgr.d value = Hh().p2().getValue();
        if (value != null) {
            Rh(value);
        }
        MutableLiveData<com.tencent.biz.qrcode.mgr.d> p26 = Hh().p2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<com.tencent.biz.qrcode.mgr.d, Unit> function14 = new Function1<com.tencent.biz.qrcode.mgr.d, Unit>() { // from class: com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment$initData$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.biz.qrcode.mgr.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.biz.qrcode.mgr.d dVar) {
                if (dVar != null) {
                    QRDisplayMyCardFragment.this.Rh(dVar);
                }
            }
        };
        p26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.biz.qrcode.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayMyCardFragment.Jh(Function1.this, obj);
            }
        });
        Oh();
    }

    private final void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
            } else {
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDarkMode(QQTheme.isNowThemeIsNight());
            }
            ((RelativeLayout) getRootView().findViewById(R.id.f30490oh)).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            RelativeLayout relativeLayout = (RelativeLayout) getRootView().findViewById(R.id.f98745nx);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.setMargins(0, ViewUtils.dpToPx(44.0f), 0, 0);
                relativeLayout.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: Dh, reason: from getter */
    public final int getCurStyle() {
        return this.curStyle;
    }

    @NotNull
    public final QRDisplayMyCardViewModel Hh() {
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = this.viewModel;
        if (qRDisplayMyCardViewModel != null) {
            return qRDisplayMyCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void Sh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rootView = view;
    }

    public final void Th(@NotNull QRDisplayMyCardViewModel qRDisplayMyCardViewModel) {
        Intrinsics.checkNotNullParameter(qRDisplayMyCardViewModel, "<set-?>");
        this.viewModel = qRDisplayMyCardViewModel;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        this.mParts.clear();
        this.mParts.add(new QRDisplayMyCardTitlePart());
        this.mParts.add(new QRDisplayMyCardPart());
        this.mParts.add(new QRDisplayMyCardButtonPart());
        return this.mParts;
    }

    @NotNull
    public final View getRootView() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Hh().f2(activity, requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Hh().y2().postValue(Boolean.TRUE);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewModel viewModel = getViewModel(QRDisplayMyCardViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QRDisplayMyCardViewModel::class.java)");
        Th((QRDisplayMyCardViewModel) viewModel);
        Hh().init();
        View inflate = inflater.inflate(R.layout.fxp, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_short, container, false)");
        Sh(inflate);
        setStatusBarImmersive();
        initData();
        Nh(getRootView().findViewById(R.id.f84374m3));
        Nh(getRootView().findViewById(R.id.f84214ln));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        View rootView = getRootView();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Hh().m3();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        setStatusBarImmersive();
        Hh().s2().postValue(Boolean.TRUE);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDarkMode(QQTheme.isNowThemeIsNight());
        }
    }
}

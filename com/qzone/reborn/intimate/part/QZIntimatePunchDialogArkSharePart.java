package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.part.QZIntimatePunchDialogArkSharePart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import ij.QZIntimateCheckInInfoBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import t7.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0004\n\u0002\b\t*\u0002RV\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010#\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010>R\u0016\u0010F\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010>R\u0016\u0010H\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010>R\u0016\u0010J\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010>R\u0016\u0010L\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010>R\u0016\u0010N\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u00104R\u0018\u0010Q\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "Lij/b;", "uiStateData", "J9", "checkInInfoBean", "", "L9", "P9", "O9", "", "spaceType", "U9", "Landroid/graphics/drawable/GradientDrawable;", "I9", "N9", "V9", "R9", "M9", "Q9", "S9", "T9", "H9", "W9", "isPartEnable", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lnk/b;", "d", "Lnk/b;", "checkInViewModel", "Lnk/p;", "e", "Lnk/p;", "settingViewModel", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "cardContainer", tl.h.F, "gradientBg", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "punchPicBg", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "firstAvatar", BdhLogUtil.LogTag.Tag_Conn, "secondAvatar", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "intimateSpaceTypeText", "E", "Landroid/view/View;", "punchCheckInDayLayout", UserInfo.SEX_FEMALE, "punchDayTextPrefix", "G", "punchDayNum", "H", "punchDayTextSuffix", "I", "punchContentText", "J", "punchContentTextSource", "K", "punchTopIcon", "L", "Lij/b;", "checkInBean", "com/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart$b", "M", "Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart$b;", "cacheBitmapListener", "com/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart$c", "N", "Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart$c;", "ntUploadPicListener", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimatePunchDialogArkSharePart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneUserAvatarView secondAvatar;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView intimateSpaceTypeText;

    /* renamed from: E, reason: from kotlin metadata */
    private View punchCheckInDayLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView punchDayTextPrefix;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView punchDayNum;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView punchDayTextSuffix;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView punchContentText;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView punchContentTextSource;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView punchTopIcon;

    /* renamed from: L, reason: from kotlin metadata */
    private QZIntimateCheckInInfoBean checkInBean;

    /* renamed from: M, reason: from kotlin metadata */
    private final b cacheBitmapListener = new b();

    /* renamed from: N, reason: from kotlin metadata */
    private final c ntUploadPicListener = new c();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.b checkInViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.p settingViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout cardContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout gradientBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView punchPicBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView firstAvatar;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart$b", "Lt7/h$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "filePath", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements h.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String str, QZIntimatePunchDialogArkSharePart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.i("QZIntimatePunchDialogArkSharePart", 1, "[onCacheBitmapDone] begin upload image");
            t7.d a16 = t7.d.INSTANCE.a();
            Intrinsics.checkNotNull(str);
            a16.n(str, this$0.ntUploadPicListener);
        }

        @Override // t7.h.a
        public void a(Bitmap bitmap, final String filePath) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            if (TextUtils.isEmpty(filePath)) {
                return;
            }
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final QZIntimatePunchDialogArkSharePart qZIntimatePunchDialogArkSharePart = QZIntimatePunchDialogArkSharePart.this;
            rFWThreadManager.execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.intimate.part.ac
                @Override // java.lang.Runnable
                public final void run() {
                    QZIntimatePunchDialogArkSharePart.b.c(filePath, qZIntimatePunchDialogArkSharePart);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimatePunchDialogArkSharePart$c", "Lt7/a;", "", "url", "fileID", "", "a", "", "errorCode", "errorMsg", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements t7.a {
        c() {
        }

        @Override // t7.a
        public void a(String url, String fileID) {
            nk.b bVar;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(fileID, "fileID");
            QLog.i("QZIntimatePunchDialogArkSharePart", 2, "\u5206\u4eabark\u56fe\u7247\u4e0a\u4f20\u5b8c\u6210,fileID=" + fileID + JefsClass.INDEX_URL + url);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || QZIntimatePunchDialogArkSharePart.this.checkInBean == null) {
                return;
            }
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = QZIntimatePunchDialogArkSharePart.this.checkInBean;
            if (qZIntimateCheckInInfoBean != null && qZIntimateCheckInInfoBean.getFriendUin() == 0) {
                return;
            }
            long uin = LoginData.getInstance().getUin();
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean2 = QZIntimatePunchDialogArkSharePart.this.checkInBean;
            QLog.i("QZIntimatePunchDialogArkSharePart", 1, "login data uin is " + uin + ", friend uin is " + (qZIntimateCheckInInfoBean2 != null ? Long.valueOf(qZIntimateCheckInInfoBean2.getFriendUin()) : null));
            nk.b bVar2 = QZIntimatePunchDialogArkSharePart.this.checkInViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
                bVar = null;
            } else {
                bVar = bVar2;
            }
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean3 = QZIntimatePunchDialogArkSharePart.this.checkInBean;
            long friendUin = qZIntimateCheckInInfoBean3 != null ? qZIntimateCheckInInfoBean3.getFriendUin() : 0L;
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean4 = QZIntimatePunchDialogArkSharePart.this.checkInBean;
            bVar.W1(peekAppRuntime, friendUin, fileID, qZIntimateCheckInInfoBean4 != null ? qZIntimateCheckInInfoBean4.getIsFriendCheckInAlready() : false);
        }

        @Override // t7.a
        public void b(long errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.i("QZIntimatePunchDialogArkSharePart", 2, "\u5206\u4eabark\u56fe\u7247\u4e0a\u4f20\u5931\u8d25,errorCode=" + LongCompanionObject.INSTANCE + ",errorMsg=" + errorMsg);
        }
    }

    private final boolean H9() {
        nk.p pVar = this.settingViewModel;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            pVar = null;
        }
        return pVar.Z1("sync_friend_switch");
    }

    private final GradientDrawable I9(int spaceType) {
        ef.a aVar = ef.a.f396213a;
        int a16 = aVar.a("#14FFFFFF", getActivity().getColor(R.color.qui_common_brand_standard));
        int a17 = aVar.a("#66FFFFFF", getActivity().getColor(R.color.qui_common_brand_standard));
        mk.d dVar = mk.d.f416875a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{a16, a17, dVar.c(activity, Integer.valueOf(spaceType))});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(UIStateData<QZIntimateCheckInInfoBean> uiStateData) {
        if (uiStateData.getData() == null) {
            return;
        }
        int state = uiStateData.getState();
        if (state != 2 && state != 3) {
            if (state != 4) {
                return;
            }
            QLog.e("QZIntimatePunchDialogArkSharePart", 1, "handleCheckInRsp error, recode is " + uiStateData.getRetCode());
            return;
        }
        QZIntimateCheckInInfoBean data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        if (L9(data)) {
            QLog.e("QZIntimatePunchDialogArkSharePart", 1, "calendar data is invalid");
            return;
        }
        QZIntimateCheckInInfoBean data2 = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data2, "uiStateData.data");
        P9(data2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean L9(QZIntimateCheckInInfoBean checkInInfoBean) {
        if (TextUtils.isEmpty(checkInInfoBean.getCalendarContent())) {
            QLog.i("QZIntimatePunchDialogArkSharePart", 1, "calendar_content is empty");
            return true;
        }
        if (!TextUtils.isEmpty(checkInInfoBean.getCalendarTips())) {
            return false;
        }
        QLog.i("QZIntimatePunchDialogArkSharePart", 1, "calendar_tips is empty");
        return true;
    }

    private final void M9(QZIntimateCheckInInfoBean checkInInfoBean) {
        if (ArrayUtils.isOutOfArrayIndex(1, checkInInfoBean.i())) {
            return;
        }
        QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
        bVar.f55960b = false;
        QZoneUserAvatarView qZoneUserAvatarView = this.firstAvatar;
        QZoneUserAvatarView qZoneUserAvatarView2 = null;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstAvatar");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setUser(checkInInfoBean.i().get(0).longValue(), bVar);
        QZoneUserAvatarView qZoneUserAvatarView3 = this.secondAvatar;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondAvatar");
        } else {
            qZoneUserAvatarView2 = qZoneUserAvatarView3;
        }
        qZoneUserAvatarView2.setUser(checkInInfoBean.i().get(1).longValue(), bVar);
    }

    private final void N9(QZIntimateCheckInInfoBean checkInInfoBean) {
        if (TextUtils.isEmpty(checkInInfoBean.getArkShareImgUrl())) {
            return;
        }
        ImageView imageView = this.punchPicBg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchPicBg");
            imageView = null;
        }
        imageView.setVisibility(0);
        Context context = getContext();
        ImageView imageView3 = this.punchPicBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchPicBg");
        } else {
            imageView2 = imageView3;
        }
        com.qzone.reborn.util.h.i(context, imageView2, checkInInfoBean.getArkShareImgUrl(), ImmersiveUtils.dpToPx(239.0f), ImmersiveUtils.dpToPx(159.0f));
    }

    private final void O9(QZIntimateCheckInInfoBean checkInInfoBean) {
        if (TextUtils.isEmpty(checkInInfoBean.getThemeColor())) {
            return;
        }
        try {
            TextView textView = null;
            if (checkInInfoBean.getIsFriendCheckInAlready()) {
                TextView textView2 = this.punchDayNum;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                    textView2 = null;
                }
                textView2.setTextColor(-1);
            } else {
                TextView textView3 = this.punchDayNum;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                    textView3 = null;
                }
                textView3.setTextColor(ef.a.f396213a.a(checkInInfoBean.getThemeColor(), getActivity().getColor(R.color.qui_common_brand_standard)));
            }
            TextView textView4 = this.punchDayTextSuffix;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayTextSuffix");
            } else {
                textView = textView4;
            }
            textView.setTextColor(ef.a.f396213a.a(checkInInfoBean.getThemeColor(), getActivity().getColor(R.color.qui_common_brand_standard)));
            U9(checkInInfoBean.getSpaceType());
        } catch (Exception e16) {
            QLog.e("QZIntimatePunchDialogArkSharePart", 1, "exception is " + e16);
        }
    }

    private final void P9(QZIntimateCheckInInfoBean checkInInfoBean) {
        this.checkInBean = checkInInfoBean;
        O9(checkInInfoBean);
        N9(checkInInfoBean);
        V9(checkInInfoBean);
        R9(checkInInfoBean);
        M9(checkInInfoBean);
        Q9(checkInInfoBean);
        S9(checkInInfoBean);
        T9(checkInInfoBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.view.View] */
    private final void Q9(QZIntimateCheckInInfoBean checkInInfoBean) {
        long checkInDays;
        String str;
        if (checkInInfoBean.getIsFriendCheckInAlready()) {
            checkInDays = checkInInfoBean.getCheckInDays() + 1;
        } else {
            checkInDays = checkInInfoBean.getCheckInDays();
        }
        TextView textView = null;
        if (checkInDays < 0) {
            ?? r102 = this.punchCheckInDayLayout;
            if (r102 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("punchCheckInDayLayout");
            } else {
                textView = r102;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.punchDayNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
            textView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        View view = this.punchCheckInDayLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchCheckInDayLayout");
            view = null;
        }
        view.setVisibility(0);
        TextView textView3 = this.punchDayTextPrefix;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchDayTextPrefix");
            textView3 = null;
        }
        if (checkInInfoBean.getIsFriendCheckInAlready()) {
            str = "\u6211\u4eec\u8fde\u7eed\u6253\u5361";
        } else {
            str = "\u7b49\u4f60\u4e00\u8d77\u6253\u5361";
        }
        textView3.setText(str);
        if (checkInDays == 0) {
            TextView textView4 = this.punchDayNum;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                textView4 = null;
            }
            textView4.setText("\u6253\u5361\n\u6210\u529f");
            TextView textView5 = this.punchDayNum;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                textView5 = null;
            }
            textView5.setTextSize(14.0f);
            layoutParams2.topMargin = com.qzone.reborn.util.r.f59560a.e(12);
            TextView textView6 = this.punchDayTextSuffix;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayTextSuffix");
                textView6 = null;
            }
            textView6.setVisibility(8);
        } else {
            TextView textView7 = this.punchDayNum;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                textView7 = null;
            }
            textView7.setText(String.valueOf(checkInDays));
            TextView textView8 = this.punchDayNum;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
                textView8 = null;
            }
            textView8.setTextSize(22.0f);
            layoutParams2.topMargin = com.qzone.reborn.util.r.f59560a.e(15);
            TextView textView9 = this.punchDayTextSuffix;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchDayTextSuffix");
                textView9 = null;
            }
            textView9.setVisibility(0);
        }
        TextView textView10 = this.punchDayNum;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchDayNum");
        } else {
            textView = textView10;
        }
        textView.setLayoutParams(layoutParams2);
    }

    private final void R9(QZIntimateCheckInInfoBean checkInInfoBean) {
        String spaceName;
        TextView textView = this.intimateSpaceTypeText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intimateSpaceTypeText");
            textView = null;
        }
        if (TextUtils.isEmpty(checkInInfoBean.getSpaceName())) {
            spaceName = mk.d.f416875a.i(Integer.valueOf(checkInInfoBean.getSpaceType()));
        } else {
            spaceName = checkInInfoBean.getSpaceName();
        }
        textView.setText(spaceName);
    }

    private final void S9(QZIntimateCheckInInfoBean checkInInfoBean) {
        if (TextUtils.isEmpty(checkInInfoBean.getCalendarContent())) {
            return;
        }
        QLog.i("QZIntimatePunchDialogArkSharePart", 1, "calendarContent is " + checkInInfoBean.getCalendarContent());
        TextView textView = this.punchContentText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchContentText");
            textView = null;
        }
        textView.setText(checkInInfoBean.getCalendarContent());
    }

    private final void T9(QZIntimateCheckInInfoBean checkInInfoBean) {
        TextView textView = null;
        if (TextUtils.isEmpty(checkInInfoBean.getCalendarContentSource())) {
            TextView textView2 = this.punchContentTextSource;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchContentTextSource");
            } else {
                textView = textView2;
            }
            textView.setVisibility(4);
            return;
        }
        QLog.i("QZIntimatePunchDialogArkSharePart", 1, "calendarContent is " + checkInInfoBean.getCalendarContentSource());
        TextView textView3 = this.punchContentTextSource;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchContentTextSource");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.punchContentTextSource;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchContentTextSource");
        } else {
            textView = textView4;
        }
        textView.setText(checkInInfoBean.getCalendarContentSource());
    }

    private final void U9(int spaceType) {
        GradientDrawable I9 = I9(spaceType);
        I9.setShape(0);
        FrameLayout frameLayout = this.gradientBg;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradientBg");
            frameLayout = null;
        }
        frameLayout.setBackground(I9);
    }

    private final void V9(QZIntimateCheckInInfoBean checkInInfoBean) {
        String d16 = mk.d.f416875a.d(Integer.valueOf(checkInInfoBean.getSpaceType()), checkInInfoBean.getIsFriendCheckInAlready());
        ImageView imageView = null;
        if (TextUtils.isEmpty(d16)) {
            ImageView imageView2 = this.punchTopIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("punchTopIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.punchTopIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchTopIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        Context context = getContext();
        ImageView imageView4 = this.punchTopIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("punchTopIcon");
        } else {
            imageView = imageView4;
        }
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        com.qzone.reborn.util.h.i(context, imageView, d16, rVar.e(60), rVar.e(60));
    }

    private final void W9() {
        if (!H9()) {
            QLog.i("QZIntimatePunchDialogArkSharePart", 1, "not allow to share ark to friend");
            return;
        }
        t7.h hVar = t7.h.f435520a;
        Activity activity = getActivity();
        FrameLayout frameLayout = this.cardContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            frameLayout = null;
        }
        hVar.e(activity, frameLayout, 239.0f, 159.0f, this.cacheBitmapListener);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateC\u2026kInViewModel::class.java)");
        nk.b bVar = (nk.b) viewModel;
        this.checkInViewModel = bVar;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            bVar = null;
        }
        MutableLiveData<UIStateData<QZIntimateCheckInInfoBean>> b26 = bVar.b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit> function1 = new Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimatePunchDialogArkSharePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                if (uIStateData == null) {
                    return;
                }
                QZIntimatePunchDialogArkSharePart.this.J9(uIStateData);
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimatePunchDialogArkSharePart.K9(Function1.this, obj);
            }
        });
        ViewModel viewModel2 = getViewModel(nk.p.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZIntimateS\u2026ingViewModel::class.java)");
        this.settingViewModel = (nk.p) viewModel2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "START_PLAY_CHECK_IN_ANIM")) {
            W9();
        }
    }

    @Override // com.qzone.reborn.base.k, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (super.isPartEnable()) {
            return com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qz_qmkj_checkin", null, 2, null) || gd.a.f401926a.c("KEY_CHECK_IN_ARK_SHARE", false);
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ckg, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026_dialog_ark_layout, null)");
        View findViewById = inflate.findViewById(R.id.f18974f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.ark_share_container)");
        this.cardContainer = (FrameLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f18954d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.ark_punch_pic_bg)");
        this.punchPicBg = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f18924a);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026id.ark_punch_gradient_bg)");
        this.gradientBg = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f18984g);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById(R.id.ark_user_avatar_1)");
        this.firstAvatar = (QZoneUserAvatarView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f18994h);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById(R.id.ark_user_avatar_2)");
        this.secondAvatar = (QZoneUserAvatarView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f188645);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById\u2026intimate_space_type_text)");
        this.intimateSpaceTypeText = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f18914_);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById\u2026h_dialog_day_text_layout)");
        this.punchCheckInDayLayout = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f188948);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById\u2026rk_punch_day_text_prefix)");
        this.punchDayTextPrefix = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f188746);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "contentView.findViewById(R.id.ark_punch_day_num)");
        this.punchDayNum = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f188847);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "contentView.findViewById\u2026.id.ark_punch_day_suffix)");
        this.punchDayTextSuffix = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.f18934b);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "contentView.findViewById\u2026.id.ark_punch_guide_text)");
        this.punchContentText = (TextView) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.f18944c);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "contentView.findViewById\u2026nch_guide_text_reference)");
        this.punchContentTextSource = (TextView) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.f18964e);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "contentView.findViewById(R.id.ark_right_top_img)");
        this.punchTopIcon = (ImageView) findViewById13;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ImmersiveUtils.dpToPx(239.0f), ImmersiveUtils.dpToPx(159.0f));
        layoutParams.gravity = 17;
        inflate.setVisibility(4);
        inflate.setClickable(false);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(inflate, layoutParams);
    }
}

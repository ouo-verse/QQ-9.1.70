package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
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
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.part.QZIntimateBadgeArkSharePart;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import t7.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\b\t*\u0002;?\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010&R\u0016\u00107\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0018\u0010:\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart;", "Lcom/qzone/reborn/base/k;", "Lqj/e;", "Landroid/view/View;", "contentView", "", "H9", "K9", "I9", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "spaceBean", "M9", "O9", "P9", "N9", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "b3", "", "leftText", "rightUrl", "p0", "R2", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "Lnk/ag;", "e", "Lnk/ag;", "badgeViewModel", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "cardContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "ivBadgePic", "i", "ivBottomLeft", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "firstAvatar", BdhLogUtil.LogTag.Tag_Conn, "secondAvatar", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "tvIntimateType", "E", "ivBadgeRight", UserInfo.SEX_FEMALE, "tvBottomLeft", "G", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "intimateSpaceBean", "com/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart$b", "H", "Lcom/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart$b;", "cacheBitmapListener", "com/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart$c", "I", "Lcom/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart$c;", "ntUploadPicListener", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateBadgeArkSharePart extends com.qzone.reborn.base.k implements qj.e {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneUserAvatarView secondAvatar;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView tvIntimateType;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView ivBadgeRight;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvBottomLeft;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneIntimateSpaceBean intimateSpaceBean;

    /* renamed from: H, reason: from kotlin metadata */
    private final b cacheBitmapListener = new b();

    /* renamed from: I, reason: from kotlin metadata */
    private final c ntUploadPicListener = new c();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.ag badgeViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout cardContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBadgePic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBottomLeft;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView firstAvatar;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart$b", "Lt7/h$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "filePath", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements h.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String str, QZIntimateBadgeArkSharePart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.i("QZIntimateBadgeArkSharePart", 1, "[onCacheBitmapDone] begin upload image");
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
            final QZIntimateBadgeArkSharePart qZIntimateBadgeArkSharePart = QZIntimateBadgeArkSharePart.this;
            rFWThreadManager.execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.intimate.part.j
                @Override // java.lang.Runnable
                public final void run() {
                    QZIntimateBadgeArkSharePart.b.c(filePath, qZIntimateBadgeArkSharePart);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateBadgeArkSharePart$c", "Lt7/a;", "", "url", "fileID", "", "a", "", "errorCode", "errorMsg", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements t7.a {
        c() {
        }

        @Override // t7.a
        public void a(String url, String fileID) {
            User user;
            List<User> members;
            Object obj;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(fileID, "fileID");
            QLog.i("QZIntimateBadgeArkSharePart", 2, "\u8d34\u7eb8\u5206\u4eabark\u56fe\u7247\u4e0a\u4f20\u5b8c\u6210,fileID=" + fileID + JefsClass.INDEX_URL + url);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            QZoneIntimateSpaceBean qZoneIntimateSpaceBean = QZIntimateBadgeArkSharePart.this.intimateSpaceBean;
            if (qZoneIntimateSpaceBean == null || (members = qZoneIntimateSpaceBean.getMembers()) == null) {
                user = null;
            } else {
                Iterator<T> it = members.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (!ef.b.g((User) obj)) {
                            break;
                        }
                    }
                }
                user = (User) obj;
            }
            if (user == null) {
                QZoneIntimateSpaceBean qZoneIntimateSpaceBean2 = QZIntimateBadgeArkSharePart.this.intimateSpaceBean;
                QLog.e("QZIntimateBadgeArkSharePart", 2, "[onUploadSuccess] no member:" + (qZoneIntimateSpaceBean2 != null ? qZoneIntimateSpaceBean2.getMembers() : null));
                return;
            }
            nk.ag agVar = QZIntimateBadgeArkSharePart.this.badgeViewModel;
            if (agVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("badgeViewModel");
                agVar = null;
            }
            long j3 = user.uin;
            nk.at atVar = QZIntimateBadgeArkSharePart.this.mainTabViewModel;
            if (atVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                atVar = null;
            }
            String mSpaceId = atVar.getMSpaceId();
            mk.d dVar = mk.d.f416875a;
            QZoneIntimateSpaceBean qZoneIntimateSpaceBean3 = QZIntimateBadgeArkSharePart.this.intimateSpaceBean;
            agVar.O1(peekAppRuntime, j3, fileID, mSpaceId, (r17 & 16) != 0 ? null : dVar.h(qZoneIntimateSpaceBean3 != null ? Integer.valueOf(qZoneIntimateSpaceBean3.getSpaceType()) : null), (r17 & 32) != 0 ? Boolean.FALSE : null);
        }

        @Override // t7.a
        public void b(long errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.i("QZIntimateBadgeArkSharePart", 2, "\u8d34\u7eb8\u5206\u4eabark\u56fe\u7247\u4e0a\u4f20\u5931\u8d25,errorCode=" + LongCompanionObject.INSTANCE + ",errorMsg=" + errorMsg);
        }
    }

    private final void H9(View contentView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ImmersiveUtils.dpToPx(239.0f), ImmersiveUtils.dpToPx(159.0f));
        layoutParams.gravity = 1;
        contentView.setVisibility(4);
        contentView.setClickable(false);
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) partRootView).addView(contentView, layoutParams);
    }

    private final void I9() {
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        this.mainTabViewModel = (nk.at) viewModel;
        ViewModel viewModel2 = getViewModel(nk.ag.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026dgeViewModel::class.java)");
        this.badgeViewModel = (nk.ag) viewModel2;
        nk.at atVar = this.mainTabViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateBadgeArkSharePart$initCheckInViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                if ((uIStateData != null ? uIStateData.getData() : null) == null || ArrayUtils.isOutOfArrayIndex(0, mk.b.d(uIStateData.getData()))) {
                    return;
                }
                QZIntimateBadgeArkSharePart.this.b3(uIStateData.getData());
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateBadgeArkSharePart.J9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9(QZoneIntimateSpaceBean spaceBean) {
        if (ArrayUtils.isOutOfArrayIndex(1, spaceBean.getMembers())) {
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
        qZoneUserAvatarView.setUser(spaceBean.getMembers().get(0), bVar);
        QZoneUserAvatarView qZoneUserAvatarView3 = this.secondAvatar;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondAvatar");
        } else {
            qZoneUserAvatarView2 = qZoneUserAvatarView3;
        }
        qZoneUserAvatarView2.setUser(spaceBean.getMembers().get(1), bVar);
    }

    private final void M9(QZoneIntimateSpaceBean spaceBean) {
        Context context = getContext();
        ImageView imageView = this.ivBadgePic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBadgePic");
            imageView = null;
        }
        com.qzone.reborn.util.h.i(context, imageView, mk.d.f416875a.f(Integer.valueOf(spaceBean.getSpaceType())).getFirst(), ImmersiveUtils.dpToPx(239.0f), ImmersiveUtils.dpToPx(159.0f));
    }

    private final void N9(QZoneIntimateSpaceBean spaceBean) {
        TextView textView = this.tvIntimateType;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIntimateType");
            textView = null;
        }
        textView.setText(mk.d.f416875a.i(Integer.valueOf(spaceBean.getSpaceType())));
    }

    private final void O9(QZoneIntimateSpaceBean spaceBean) {
        Context context = getContext();
        ImageView imageView = this.ivBottomLeft;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBottomLeft");
            imageView = null;
        }
        com.qzone.reborn.util.h.i(context, imageView, mk.d.f416875a.f(Integer.valueOf(spaceBean.getSpaceType())).getSecond(), ImmersiveUtils.dpToPx(18.0f), ImmersiveUtils.dpToPx(18.0f));
    }

    private final void P9(QZoneIntimateSpaceBean spaceBean) {
        TextView textView = this.tvBottomLeft;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBottomLeft");
            textView = null;
        }
        mk.d dVar = mk.d.f416875a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        textView.setTextColor(dVar.g(activity, Integer.valueOf(spaceBean.getSpaceType())));
    }

    @Override // qj.e
    public void R2() {
        t7.h hVar = t7.h.f435520a;
        Activity activity = getActivity();
        FrameLayout frameLayout = this.cardContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            frameLayout = null;
        }
        hVar.e(activity, frameLayout, 239.0f, 159.0f, this.cacheBitmapListener);
    }

    @Override // qj.e
    public void b3(QZoneIntimateSpaceBean spaceBean) {
        QLog.i("QZIntimateBadgeArkSharePart", 1, "[showArkContentCard] spaceBean\uff1a" + spaceBean);
        this.intimateSpaceBean = spaceBean;
        if (spaceBean == null) {
            return;
        }
        M9(spaceBean);
        O9(spaceBean);
        P9(spaceBean);
        N9(spaceBean);
        L9(spaceBean);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cjc, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026e_ark_share_layout, null)");
        H9(inflate);
        registerIoc(this, qj.e.class);
        K9(inflate);
        I9();
    }

    @Override // qj.e
    public void p0(String leftText, String rightUrl) {
        TextView textView = this.tvBottomLeft;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBottomLeft");
            textView = null;
        }
        textView.setText(leftText);
        Context context = getContext();
        ImageView imageView2 = this.ivBadgeRight;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBadgeRight");
        } else {
            imageView = imageView2;
        }
        com.qzone.reborn.util.h.i(context, imageView, rightUrl, ImmersiveUtils.dpToPx(130.0f), ImmersiveUtils.dpToPx(130.0f));
    }

    private final void K9(View contentView) {
        View findViewById = contentView.findViewById(R.id.f162807mqq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026adge_ark_share_container)");
        this.cardContainer = (FrameLayout) findViewById;
        View findViewById2 = contentView.findViewById(R.id.mqo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026d.qzone_badge_ark_pic_bg)");
        this.ivBadgePic = (ImageView) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.mqr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026_badge_ark_user_avatar_1)");
        this.firstAvatar = (QZoneUserAvatarView) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.mqs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById\u2026_badge_ark_user_avatar_2)");
        this.secondAvatar = (QZoneUserAvatarView) findViewById4;
        View findViewById5 = contentView.findViewById(R.id.mqn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById\u2026e_ark_intimate_type_text)");
        this.tvIntimateType = (TextView) findViewById5;
        View findViewById6 = contentView.findViewById(R.id.mqp);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById\u2026zone_badge_ark_right_img)");
        this.ivBadgeRight = (ImageView) findViewById6;
        View findViewById7 = contentView.findViewById(R.id.mql);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById\u2026dge_ark_bottom_left_icon)");
        this.ivBottomLeft = (ImageView) findViewById7;
        View findViewById8 = contentView.findViewById(R.id.mqm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById\u2026dge_ark_bottom_left_text)");
        this.tvBottomLeft = (TextView) findViewById8;
    }
}

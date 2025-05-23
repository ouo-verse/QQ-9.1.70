package com.qzone.reborn.albumx.qzonex.section.albumdetail;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.FamilyRole;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nc.y;
import wa.QZAlbumxParentFamilyBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0014J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0016J*\u0010'\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u00162\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0014R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/section/albumdetail/QZAlbumxAlbumDetailInviteSection;", "Lcom/qzone/reborn/base/l;", "Lxa/a;", "Landroid/view/View$OnClickListener;", "data", "", "a0", "", "K", "", "G", "V", "U", "M", "Y", "O", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lnc/y;", "J", "Lnc/o;", "L", "", "role", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "view", "H", "getLogTag", "", "getViewStubLayoutId", "containerView", "onInitView", "v", NodeProps.ON_CLICK, "position", "", "", "payload", "W", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "inviteBtn", "f", "I", "pageId", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", tl.h.F, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "shareAlbumMeta", "i", "Z", "getApplied", "()Z", "X", "(Z)V", "applied", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailInviteSection extends com.qzone.reborn.base.l<xa.a> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView inviteBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int pageId = 1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonShareAlbumMeta shareAlbumMeta;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean applied;

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int role) {
        MutableLiveData<CommonAlbumInfo> M1;
        if (this.applied) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.f
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxAlbumDetailInviteSection.F(QZAlbumxAlbumDetailInviteSection.this);
                }
            });
            return;
        }
        nc.o L = L();
        if (L != null) {
            y J = J();
            L.T1((J == null || (M1 = J.M1()) == null) ? null : M1.getValue());
        }
        nc.o L2 = L();
        if (L2 != null) {
            L2.a2(role, new n.a<Boolean>() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.QZAlbumxAlbumDetailInviteSection$applyJoinAlbum$2
                public void a(boolean t16, long retCode, String msg2, boolean isFinish) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QZAlbumxAlbumDetailInviteSection.this.X(true);
                    final QZAlbumxAlbumDetailInviteSection qZAlbumxAlbumDetailInviteSection = QZAlbumxAlbumDetailInviteSection.this;
                    com.tencent.qqnt.aio.util.d.c(new Function0<Unit>() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.QZAlbumxAlbumDetailInviteSection$applyJoinAlbum$2$onSuccess$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            TextView textView;
                            textView = QZAlbumxAlbumDetailInviteSection.this.inviteBtn;
                            if (textView == null) {
                                return;
                            }
                            textView.setText(com.qzone.util.l.a(R.string.f133967j));
                        }
                    });
                }

                @Override // com.qzone.reborn.base.n.a
                public /* bridge */ /* synthetic */ void onSuccess(Boolean bool, long j3, String str, boolean z16) {
                    a(bool.booleanValue(), j3, str, z16);
                }

                @Override // com.qzone.reborn.base.n.a
                public void onFailure(long errorCode, String errorMsg) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QZAlbumxAlbumDetailInviteSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.p(), 4, com.qzone.util.l.a(R.string.f134007n), 0).show();
    }

    private final boolean G() {
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        CommonShareAlbumMeta shareAlbum;
        List<CommonClientAttr> e16;
        if (this.pageId != 4) {
            return true;
        }
        y J = J();
        return ((J == null || (M1 = J.M1()) == null || (value = M1.getValue()) == null || (shareAlbum = value.getShareAlbum()) == null || (e16 = shareAlbum.e()) == null) ? 0 : e16.size()) < 2;
    }

    private final y J() {
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getRootView(), null);
        com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
        if (Ne instanceof y) {
            return (y) Ne;
        }
        return null;
    }

    private final String K(xa.a data) {
        if (data.g().contains(2)) {
            this.applied = false;
            String a16 = com.qzone.util.l.a(R.string.f1341885);
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            applied = \u2026_member_invite)\n        }");
            return a16;
        }
        if (data.g().contains(3)) {
            this.applied = false;
            String a17 = com.qzone.util.l.a(R.string.f133977k);
            Intrinsics.checkNotNullExpressionValue(a17, "{\n            applied = \u2026m_detail_apply)\n        }");
            return a17;
        }
        if (data.g().contains(4)) {
            this.applied = true;
            String a18 = com.qzone.util.l.a(R.string.f133967j);
            Intrinsics.checkNotNullExpressionValue(a18, "{\n            applied = \u2026detail_applied)\n        }");
            return a18;
        }
        return "";
    }

    private final nc.o L() {
        return (nc.o) t(nc.o.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        MutableLiveData<Boolean> B2;
        MutableLiveData<Boolean> B22;
        T t16 = this.mData;
        if (t16 != 0 && !((xa.a) t16).g().isEmpty()) {
            if (((xa.a) this.mData).g().contains(2)) {
                y J = J();
                if (J == null || (B22 = J.B2()) == null) {
                    return;
                }
                B22.postValue(Boolean.TRUE);
                return;
            }
            if (((xa.a) this.mData).g().contains(3)) {
                Y();
                return;
            }
            if (((xa.a) this.mData).g().contains(4)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailInviteSection.N(QZAlbumxAlbumDetailInviteSection.this);
                    }
                });
                return;
            }
            if (!V() && !U()) {
                Y();
                return;
            }
            y J2 = J();
            if (J2 == null || (B2 = J2.B2()) == null) {
                return;
            }
            B2.postValue(Boolean.TRUE);
            return;
        }
        QLog.e("QZAlbumxAlbumDetailInviteSection", 1, "mData or rightList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(QZAlbumxAlbumDetailInviteSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.p(), 4, com.qzone.util.l.a(R.string.f134007n), 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O() {
        MutableLiveData<Boolean> B2;
        MutableLiveData<Boolean> B22;
        T t16 = this.mData;
        if (t16 != 0 && !((xa.a) t16).g().isEmpty()) {
            if (((xa.a) this.mData).g().contains(2)) {
                y J = J();
                if (J == null || (B22 = J.B2()) == null) {
                    return;
                }
                B22.postValue(Boolean.TRUE);
                return;
            }
            if (((xa.a) this.mData).g().contains(3)) {
                D(this, 0, 1, null);
                return;
            }
            if (((xa.a) this.mData).g().contains(4)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailInviteSection.P(QZAlbumxAlbumDetailInviteSection.this);
                    }
                });
                return;
            }
            if (!V() && !U()) {
                D(this, 0, 1, null);
                return;
            }
            y J2 = J();
            if (J2 == null || (B2 = J2.B2()) == null) {
                return;
            }
            B2.postValue(Boolean.TRUE);
            return;
        }
        QLog.e("QZAlbumxAlbumDetailInviteSection", 1, "mData or rightList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QZAlbumxAlbumDetailInviteSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.p(), 4, com.qzone.util.l.a(R.string.f134007n), 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q() {
        MutableLiveData<Boolean> B2;
        MutableLiveData<Boolean> B22;
        T t16 = this.mData;
        if (t16 != 0 && !((xa.a) t16).g().isEmpty()) {
            if (((xa.a) this.mData).g().contains(2)) {
                y J = J();
                if (J == null || (B22 = J.B2()) == null) {
                    return;
                }
                B22.postValue(Boolean.TRUE);
                return;
            }
            if (((xa.a) this.mData).g().contains(3)) {
                D(this, 0, 1, null);
                return;
            }
            if (((xa.a) this.mData).g().contains(4)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailInviteSection.R(QZAlbumxAlbumDetailInviteSection.this);
                    }
                });
                return;
            }
            if (!V() && !U()) {
                D(this, 0, 1, null);
                return;
            }
            y J2 = J();
            if (J2 == null || (B2 = J2.B2()) == null) {
                return;
            }
            B2.postValue(Boolean.TRUE);
            return;
        }
        QLog.e("QZAlbumxAlbumDetailInviteSection", 1, "mData or rightList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(QZAlbumxAlbumDetailInviteSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.p(), 4, com.qzone.util.l.a(R.string.f134007n), 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S() {
        MutableLiveData<Boolean> B2;
        MutableLiveData<Boolean> B22;
        T t16 = this.mData;
        if (t16 != 0 && !((xa.a) t16).g().isEmpty()) {
            if (((xa.a) this.mData).g().contains(2)) {
                y J = J();
                if (J == null || (B22 = J.B2()) == null) {
                    return;
                }
                B22.postValue(Boolean.TRUE);
                return;
            }
            if (((xa.a) this.mData).g().contains(3)) {
                D(this, 0, 1, null);
                return;
            }
            if (((xa.a) this.mData).g().contains(4)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxAlbumDetailInviteSection.T(QZAlbumxAlbumDetailInviteSection.this);
                    }
                });
                return;
            }
            if (!V() && !U()) {
                D(this, 0, 1, null);
                return;
            }
            y J2 = J();
            if (J2 == null || (B2 = J2.B2()) == null) {
                return;
            }
            B2.postValue(Boolean.TRUE);
            return;
        }
        QLog.e("QZAlbumxAlbumDetailInviteSection", 1, "mData or rightList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(QZAlbumxAlbumDetailInviteSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.p(), 4, com.qzone.util.l.a(R.string.f134007n), 0).show();
    }

    private final boolean U() {
        CommonShareAlbumMeta commonShareAlbumMeta = this.shareAlbumMeta;
        if (commonShareAlbumMeta == null) {
            return false;
        }
        Intrinsics.checkNotNull(commonShareAlbumMeta);
        Iterator<CommonClientAttr> it = commonShareAlbumMeta.e().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), LoginData.getInstance().getUinString())) {
                return true;
            }
        }
        return false;
    }

    private final boolean V() {
        CommonStUser owner;
        CommonShareAlbumMeta commonShareAlbumMeta = this.shareAlbumMeta;
        return Intrinsics.areEqual((commonShareAlbumMeta == null || (owner = commonShareAlbumMeta.getOwner()) == null) ? null : owner.getUin(), LoginData.getInstance().getUinString());
    }

    private final void Y() {
        if (this.applied) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.g
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxAlbumDetailInviteSection.Z(QZAlbumxAlbumDetailInviteSection.this);
                }
            });
            return;
        }
        QZAlbumxParentFamilyBean b16 = com.qzone.reborn.albumx.qzonex.utils.b.f53400a.b(FamilyRole.KFAMILYROLEMOTHER.ordinal());
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog = new QZAlbumxParentingSelectIdentityDialog(activity, b16);
        qZAlbumxParentingSelectIdentityDialog.b0(new b(b16, this));
        qZAlbumxParentingSelectIdentityDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(QZAlbumxAlbumDetailInviteSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.p(), 4, com.qzone.util.l.a(R.string.f134007n), 0).show();
    }

    private final void a0(xa.a data) {
        String joinToString$default;
        int i3 = this.pageId;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(data.g(), ", ", "[", "]", 0, null, null, 56, null);
        QLog.i("QZAlbumxAlbumDetailInviteSection", 2, "pageId: " + i3 + ", rightList:" + joinToString$default);
        String K = K(data);
        if (K == null || K.length() == 0) {
            TextView textView = this.inviteBtn;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.inviteBtn;
        if (textView2 != null) {
            textView2.setText(K);
        }
        TextView textView3 = this.inviteBtn;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        if (!G()) {
            TextView textView4 = this.inviteBtn;
            if (textView4 == null) {
                return;
            }
            textView4.setVisibility(8);
            return;
        }
        TextView textView5 = this.inviteBtn;
        if (textView5 == null) {
            return;
        }
        textView5.setVisibility(0);
    }

    public final void X(boolean z16) {
        this.applied = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailInviteSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        int i3 = this.pageId;
        if (i3 == 2) {
            M();
        } else if (i3 == 3) {
            S();
        } else if (i3 == 4) {
            O();
        } else if (i3 == 5) {
            Q();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void onBindData(xa.a data, int position, List<Object> payload) {
        if (data != null) {
            this.pageId = data.getPageId();
            this.shareAlbumMeta = data.getShareAlbumMeta();
            a0(data);
            H(this.inviteBtn);
        }
    }

    private final void H(View view) {
        if (view == null) {
            return;
        }
        fo.c.o(view, "em_qz_invite_btn", new fo.b());
    }

    static /* synthetic */ void D(QZAlbumxAlbumDetailInviteSection qZAlbumxAlbumDetailInviteSection, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = FamilyRole.KFAMILYROLENONE.ordinal();
        }
        qZAlbumxAlbumDetailInviteSection.C(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        TextView textView = containerView != null ? (TextView) containerView.findViewById(R.id.krp) : null;
        this.inviteBtn = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.inviteBtn;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(8);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/section/albumdetail/QZAlbumxAlbumDetailInviteSection$b", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "", "onCancel", "Lwa/b;", "selectedBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZAlbumxParentingSelectIdentityDialog.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZAlbumxParentFamilyBean f53345a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZAlbumxAlbumDetailInviteSection f53346b;

        b(QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean, QZAlbumxAlbumDetailInviteSection qZAlbumxAlbumDetailInviteSection) {
            this.f53345a = qZAlbumxParentFamilyBean;
            this.f53346b = qZAlbumxAlbumDetailInviteSection;
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void a(QZAlbumxParentFamilyBean selectedBean) {
            RFWLog.i("QZAlbumxAlbumDetailInviteSection", RFWLog.USR, "onConfirm  selectedIdentityBean=" + this.f53345a + ", afterSelectedBean=" + selectedBean);
            if (selectedBean == null || TextUtils.isEmpty(selectedBean.getName())) {
                return;
            }
            this.f53346b.C(selectedBean.getRoleId());
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void onCancel() {
        }
    }
}

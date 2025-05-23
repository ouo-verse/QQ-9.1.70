package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean;
import com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxApplicationBottomPart;
import com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBabyOperatePart;
import com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBottomPart;
import com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteHeadPart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0015H\u0014R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxInviteFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/content/Intent;", "intent", "", "parseIntent", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", "ph", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", "rh", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;)V", "invitePageInitBean", "Lnc/bf;", "D", "Lkotlin/Lazy;", "qh", "()Lnc/bf;", "inviteViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxInviteFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    public QZAlbumxInvitePageInitBean invitePageInitBean;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy inviteViewModel;

    public QZAlbumxInviteFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<bf>() { // from class: com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxInviteFragment$inviteViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final bf invoke() {
                return (bf) QZAlbumxInviteFragment.this.getViewModel(bf.class);
            }
        });
        this.inviteViewModel = lazy;
    }

    private final bf qh() {
        Object value = this.inviteViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inviteViewModel>(...)");
        return (bf) value;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = 1;
        if (ph().getPageType() != 1 || !qh().o2()) {
            if (ph().getPageType() == 0 && qh().n2()) {
                i3 = 3;
            } else {
                i3 = (qh().n2() || qh().o2()) ? 0 : 2;
            }
        }
        linkedHashMap.put("pg_state", Integer.valueOf(i3));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128884k;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_invite_applt_middle";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        parseIntent(activity != null ? activity.getIntent() : null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public final QZAlbumxInvitePageInitBean ph() {
        QZAlbumxInvitePageInitBean qZAlbumxInvitePageInitBean = this.invitePageInitBean;
        if (qZAlbumxInvitePageInitBean != null) {
            return qZAlbumxInvitePageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("invitePageInitBean");
        return null;
    }

    public final void rh(QZAlbumxInvitePageInitBean qZAlbumxInvitePageInitBean) {
        Intrinsics.checkNotNullParameter(qZAlbumxInvitePageInitBean, "<set-?>");
        this.invitePageInitBean = qZAlbumxInvitePageInitBean;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZAlbumxInviteHeadPart(), new QZAlbumxInviteBabyOperatePart(), new QZAlbumxInviteBottomPart(), new QZAlbumxApplicationBottomPart());
        return mutableListOf;
    }

    public final void parseIntent(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean");
        rh((QZAlbumxInvitePageInitBean) serializable);
    }
}

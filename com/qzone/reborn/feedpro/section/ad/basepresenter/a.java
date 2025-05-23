package com.qzone.reborn.feedpro.section.ad.basepresenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001>B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u0010;\u001a\u000605R\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b\u0010\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a;", "Lne/a;", "Landroid/view/View$OnClickListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "G", "E", "Landroid/view/View;", "getMAdContainerView", "()Landroid/view/View;", "setMAdContainerView", "(Landroid/view/View;)V", "mAdContainerView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "getMAdIcon", "()Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "setMAdIcon", "(Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;)V", "mAdIcon", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "getMAdName", "()Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "setMAdName", "(Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;)V", "mAdName", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "H", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "getMAdDes", "()Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "setMAdDes", "(Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;)V", "mAdDes", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "getMAdFeedBackIcon", "()Landroid/widget/ImageView;", "setMAdFeedBackIcon", "(Landroid/widget/ImageView;)V", "mAdFeedBackIcon", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a$a;", "J", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a$a;", "()Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a$a;", "setMAdFeedHeadData", "(Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a$a;)V", "mAdFeedHeadData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class a extends ne.a implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    private View mAdContainerView;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneUserAvatarView mAdIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneNickNameView mAdName;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneRichTextView mAdDes;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mAdFeedBackIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private C0455a mAdFeedHeadData = new C0455a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "adIcon", "c", "f", "adName", "d", "adDes", "<init>", "(Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.section.ad.basepresenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public final class C0455a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String adIcon = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String adName = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String adDes = "";

        public C0455a() {
        }

        /* renamed from: a, reason: from getter */
        public final String getAdDes() {
            return this.adDes;
        }

        /* renamed from: b, reason: from getter */
        public final String getAdIcon() {
            return this.adIcon;
        }

        /* renamed from: c, reason: from getter */
        public final String getAdName() {
            return this.adName;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adDes = str;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adIcon = str;
        }

        public final void f(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adName = str;
        }
    }

    /* renamed from: E, reason: from getter */
    public final C0455a getMAdFeedHeadData() {
        return this.mAdFeedHeadData;
    }

    public abstract void F();

    public void G() {
        User user = new User();
        user.logo = this.mAdFeedHeadData.getAdIcon();
        user.from = 2;
        QZoneUserAvatarView qZoneUserAvatarView = this.mAdIcon;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser(user);
        }
        QZoneNickNameView qZoneNickNameView = this.mAdName;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setText(GdtUIUtils.getValidAdName(this.mAdFeedHeadData.getAdName()));
        }
        QZoneRichTextView qZoneRichTextView = this.mAdDes;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setRichText(this.mAdFeedHeadData.getAdDes());
        }
        QZoneRichTextView qZoneRichTextView2 = this.mAdDes;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setLineSpace(ImmersiveUtils.dpToPx(1.5f));
        }
        QZoneRichTextView qZoneRichTextView3 = this.mAdDes;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setVisibility(TextUtils.isEmpty(this.mAdFeedHeadData.getAdDes()) ? 8 : 0);
        }
        View view = this.mAdContainerView;
        if (view != null) {
            view.setVisibility(0);
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mAdIcon;
        if (qZoneUserAvatarView2 != null) {
            qZoneUserAvatarView2.setOnClickListener(this);
        }
        QZoneNickNameView qZoneNickNameView2 = this.mAdName;
        if (qZoneNickNameView2 != null) {
            qZoneNickNameView2.setOnClickListener(this);
        }
        QZoneRichTextView qZoneRichTextView4 = this.mAdDes;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setOnClickListener(this);
        }
        ImageView imageView = this.mAdFeedBackIcon;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        View view2 = this.mAdContainerView;
        if (view2 == null) {
            return;
        }
        view2.setContentDescription(this.mAdFeedHeadData.getAdName() + "," + this.mAdFeedHeadData.getAdDes());
    }

    @Override // ne.a
    protected int q() {
        return R.id.nn7;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (getMFeedData() == null) {
            QLog.e(getTAG(), 1, "[onBindData] error, feeddata is null");
            return;
        }
        View view = this.mAdContainerView;
        if (view != null) {
            view.setVisibility(8);
        }
        F();
        G();
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mAdContainerView = containerView;
        this.mAdIcon = (QZoneUserAvatarView) containerView.findViewById(R.id.mlq);
        QZoneNickNameView qZoneNickNameView = (QZoneNickNameView) containerView.findViewById(R.id.mmr);
        this.mAdName = qZoneNickNameView;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setTextBold(true);
        }
        this.mAdDes = (QZoneRichTextView) containerView.findViewById(R.id.mmb);
        this.mAdFeedBackIcon = (ImageView) containerView.findViewById(R.id.mmc);
    }
}

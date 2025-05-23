package com.qzone.reborn.feedx.presenter.ad.basepresenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import gf.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001GB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00107\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010(\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R$\u0010>\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R&\u0010D\u001a\u00060?R\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010@\u001a\u0004\b.\u0010A\"\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b;", "Lvg/a;", "Landroid/view/View$OnClickListener;", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M", "O", UserInfo.SEX_FEMALE, "Landroid/view/View;", "H", "()Landroid/view/View;", "setMAdContainerView", "(Landroid/view/View;)V", "mAdContainerView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "G", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "getMAdIcon", "()Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "setMAdIcon", "(Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;)V", "mAdIcon", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "K", "()Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "setMAdName", "(Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;)V", "mAdName", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "I", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "()Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "setMAdDes", "(Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;)V", "mAdDes", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "getMOption", "()Landroid/widget/ImageView;", "setMOption", "(Landroid/widget/ImageView;)V", "mOption", "getMAdFeedBackText", "setMAdFeedBackText", "mAdFeedBackText", "Lgf/h;", "L", "Lgf/h;", "()Lgf/h;", "N", "(Lgf/h;)V", "mInteractOperateIoc", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b$a;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b$a;", "()Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b$a;", "setMAdFeedHeadData", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b$a;)V", "mAdFeedHeadData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class b extends vg.a implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private View mAdContainerView;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneUserAvatarView mAdIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneNickNameView mAdName;

    /* renamed from: I, reason: from kotlin metadata */
    private QZoneRichTextView mAdDes;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mOption;

    /* renamed from: K, reason: from kotlin metadata */
    private QZoneRichTextView mAdFeedBackText;

    /* renamed from: L, reason: from kotlin metadata */
    private h mInteractOperateIoc;

    /* renamed from: M, reason: from kotlin metadata */
    private a mAdFeedHeadData = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "adIcon", "c", "g", "adName", "e", "adDes", "d", tl.h.F, "adTime", "<init>", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String adIcon = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String adName = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String adDes = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String adTime = "";

        public a() {
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

        /* renamed from: d, reason: from getter */
        public final String getAdTime() {
            return this.adTime;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adDes = str;
        }

        public final void f(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adIcon = str;
        }

        public final void g(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adName = str;
        }

        public final void h(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adTime = str;
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        if (this.f441565h == null) {
            QLog.e(getTAG(), 1, "[onBindData] error, feeddata is null");
            return;
        }
        View view = this.mAdContainerView;
        if (view != null) {
            view.setVisibility(8);
        }
        M();
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    public void C(View containerView) {
        this.mAdContainerView = containerView;
        this.mAdIcon = containerView != null ? (QZoneUserAvatarView) containerView.findViewById(R.id.mlq) : null;
        this.mAdName = containerView != null ? (QZoneNickNameView) containerView.findViewById(R.id.mmr) : null;
        this.mAdDes = containerView != null ? (QZoneRichTextView) containerView.findViewById(R.id.mmb) : null;
        this.mOption = containerView != null ? (ImageView) containerView.findViewById(R.id.mmc) : null;
        this.mAdFeedBackText = containerView != null ? (QZoneRichTextView) containerView.findViewById(R.id.mmd) : null;
        if (containerView != null) {
            int color = containerView.getResources().getColor(R.color.qui_common_text_primary);
            QZoneNickNameView qZoneNickNameView = this.mAdName;
            if (qZoneNickNameView != null) {
                qZoneNickNameView.setTextColor(color);
            }
            QZoneRichTextView qZoneRichTextView = this.mAdDes;
            if (qZoneRichTextView != null) {
                qZoneRichTextView.setTextColor(color);
            }
            int color2 = containerView.getResources().getColor(R.color.qui_common_text_secondary);
            QZoneRichTextView qZoneRichTextView2 = this.mAdFeedBackText;
            if (qZoneRichTextView2 != null) {
                qZoneRichTextView2.setTextColor(color2);
            }
        }
    }

    /* renamed from: H, reason: from getter */
    public final View getMAdContainerView() {
        return this.mAdContainerView;
    }

    /* renamed from: I, reason: from getter */
    public final QZoneRichTextView getMAdDes() {
        return this.mAdDes;
    }

    /* renamed from: J, reason: from getter */
    public final a getMAdFeedHeadData() {
        return this.mAdFeedHeadData;
    }

    /* renamed from: K, reason: from getter */
    public final QZoneNickNameView getMAdName() {
        return this.mAdName;
    }

    /* renamed from: L, reason: from getter */
    public final h getMInteractOperateIoc() {
        return this.mInteractOperateIoc;
    }

    public abstract void M();

    public final void N(h hVar) {
        this.mInteractOperateIoc = hVar;
    }

    public void O() {
        User user = new User();
        user.logo = this.mAdFeedHeadData.getAdIcon();
        user.from = 2;
        QZoneUserAvatarView qZoneUserAvatarView = this.mAdIcon;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser(user);
        }
        QZoneNickNameView qZoneNickNameView = this.mAdName;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setText(this.mAdFeedHeadData.getAdName());
        }
        QZoneRichTextView qZoneRichTextView = this.mAdDes;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setText(this.mAdFeedHeadData.getAdDes());
        }
        QZoneRichTextView qZoneRichTextView2 = this.mAdDes;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setVisibility(TextUtils.isEmpty(this.mAdFeedHeadData.getAdDes()) ? 8 : 0);
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
        QZoneRichTextView qZoneRichTextView3 = this.mAdDes;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setOnClickListener(this);
        }
        QZoneRichTextView qZoneRichTextView4 = this.mAdFeedBackText;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setOnClickListener(this);
        }
        ImageView imageView = this.mOption;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        View view2 = this.mAdContainerView;
        if (view2 == null) {
            return;
        }
        view2.setContentDescription(this.mAdFeedHeadData.getAdName() + "," + this.mAdFeedHeadData.getAdDes());
    }

    @Override // vg.a
    protected int s() {
        return R.id.nn7;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}

package com.tencent.biz.qqcircle.comment.emoji;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSCommentPicPreview extends CoordinatorLayout {
    private String C;
    private int D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private View f83613d;

    /* renamed from: e, reason: collision with root package name */
    private SquareImageView f83614e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f83615f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.abovebar.a f83616h;

    /* renamed from: i, reason: collision with root package name */
    private String f83617i;

    /* renamed from: m, reason: collision with root package name */
    private String f83618m;

    public QFSCommentPicPreview(@NonNull Context context) {
        this(context, null);
    }

    private void j() {
        IDynamicParams iDynamicParams = new IDynamicParams() { // from class: com.tencent.biz.qqcircle.comment.emoji.p
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map u16;
                u16 = QFSCommentPicPreview.this.u(str);
                return u16;
            }
        };
        VideoReport.setElementId(this.f83613d, "em_xsj_clck_preview");
        View view = this.f83613d;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setEventDynamicParams(this.f83613d, iDynamicParams);
        VideoReport.setElementId(this.f83615f, QCircleDaTongConstant.ElementId.EM_XSJ_IMAGE_CLOSE_BUTTON);
        VideoReport.setElementExposePolicy(this.f83615f, exposurePolicy);
        VideoReport.setEventDynamicParams(this.f83615f, iDynamicParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("QFSCommentPicPreview", 1, "on emoji delete");
        this.f83614e.setImageDrawable(null);
        k();
        this.f83615f.setVisibility(8);
        z(false);
        ak.f83788a.a();
        EventCollector.getInstance().onViewClicked(view);
    }

    private String n() {
        if (!TextUtils.isEmpty(this.E)) {
            return this.E;
        }
        if (!TextUtils.isEmpty(this.f83618m)) {
            return this.f83618m;
        }
        if (!TextUtils.isEmpty(this.f83617i)) {
            return this.f83617i;
        }
        return "";
    }

    private void s(final Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168624g35, (ViewGroup) this, true);
        this.f83613d = inflate;
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.f31020px);
        this.f83615f = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.emoji.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentPicPreview.this.l(view);
            }
        });
        this.f83614e = (SquareImageView) this.f83613d.findViewById(R.id.f32570u4);
        if (!uq3.k.a().c("hasShownSelectedThumbPreviewHint", false)) {
            this.f83613d.findViewById(R.id.f82774hs).setVisibility(0);
        }
        this.f83613d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.emoji.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentPicPreview.this.v(context, view);
            }
        });
    }

    private boolean t() {
        if (o() == null && TextUtils.isEmpty(this.f83617i)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map u(String str) {
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        com.tencent.biz.qqcircle.comment.abovebar.a aVar = this.f83616h;
        if (aVar != null && aVar.d8() != null) {
            buildElementParams.put("dt_pgid", this.f83616h.d8().a());
            if (this.f83616h.d8().f421797e != null) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f83616h.d8().f421797e;
                buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
                FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
                if (feedCloudMeta$StUser == null) {
                    str2 = "";
                } else {
                    str2 = feedCloudMeta$StUser.f398463id.get();
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
            }
        }
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QFSCommentHelper.L().g0(context, n(), t(), q());
        uq3.k.a().j("hasShownSelectedThumbPreviewHint", true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void w(String str) {
        k();
        this.E = str;
    }

    private void x(String str, String str2) {
        k();
        this.f83617i = str;
        this.f83618m = str2;
    }

    private void y(String str) {
        this.C = str;
    }

    private void z(boolean z16) {
        int i3;
        if (this.f83616h == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
        this.f83616h.m3(z16);
    }

    public void A(String str) {
        this.D = 10003;
        w(str);
        C(str);
        y(null);
    }

    public void B(String str, String str2) {
        this.D = 10001;
        x(str, str2);
        C(str);
    }

    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSCommentPicPreview", 1, "empty url");
            return;
        }
        if (this.f83614e != null && this.f83615f != null) {
            com.tencent.biz.qqcircle.helpers.u uVar = com.tencent.biz.qqcircle.helpers.u.f84666a;
            if (!uVar.a()) {
                this.f83614e.clearColorFilter();
            } else if (this.D == 10003) {
                uVar.b(this.f83614e);
            }
            QLog.d("QFSCommentPicPreview", 1, "[updateEmojiPreview] url: " + str);
            Option obtain = Option.obtain();
            obtain.setUrl(str);
            obtain.setTargetView(this.f83614e);
            obtain.setLoadingDrawableColor(0);
            QCircleFeedPicLoader.g().loadImage(obtain);
            this.f83615f.setVisibility(0);
            z(true);
            return;
        }
        QLog.d("QFSCommentPicPreview", 1, "emojiPreview is null");
    }

    public void D(String str, String str2) {
        this.D = 10002;
        k();
        this.f83617i = str;
        y(str2);
        C(str);
    }

    public void k() {
        this.f83617i = "";
        this.f83618m = "";
        this.E = "";
    }

    public String m() {
        return this.E;
    }

    public String o() {
        return this.C;
    }

    public String p() {
        return this.f83618m;
    }

    public int q() {
        return this.D;
    }

    public String r() {
        return this.f83617i;
    }

    public void setHostProxy(com.tencent.biz.qqcircle.comment.abovebar.a aVar) {
        this.f83616h = aVar;
        j();
    }

    public QFSCommentPicPreview(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = 0;
        s(context);
    }

    public QFSCommentPicPreview(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = 0;
    }
}

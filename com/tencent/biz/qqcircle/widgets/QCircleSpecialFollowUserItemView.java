package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StRelationInfo;
import feedcloud.FeedCloudMeta$StUser;
import qqcircle.QQCircleRelation$RelationBiz;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSpecialFollowUserItemView extends QCircleBaseWidgetView<FeedCloudMeta$StRelationInfo> implements View.OnClickListener {
    private String C;
    private Size D;

    /* renamed from: d, reason: collision with root package name */
    private FormItemRelativeLayout f93151d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAvatarView f93152e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93153f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93154h;

    /* renamed from: i, reason: collision with root package name */
    private URLImageView f93155i;

    /* renamed from: m, reason: collision with root package name */
    private View f93156m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(QCircleSpecialFollowUserItemView.this.C);
            QCircleSpecialFollowManager.g().f(feedCloudMeta$StUser, false, QCircleSpecialFollowUserItemView.this.getContext());
        }
    }

    public QCircleSpecialFollowUserItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93152e = (QCircleAvatarView) findViewById(R.id.f32700ug);
        this.f93153f = (TextView) findViewById(R.id.f32730uj);
        this.f93154h = (TextView) findViewById(R.id.f32720ui);
        this.f93155i = (URLImageView) findViewById(R.id.f32740uk);
        this.f93151d = (FormItemRelativeLayout) findViewById(R.id.f759940g);
        this.f93155i.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200619175130_E9peEWVngd.png");
        this.f93156m = findViewById(R.id.f32710uh);
        this.f93152e.setOnClickListener(this);
        this.f93153f.setOnClickListener(this);
        this.f93156m.setOnClickListener(this);
        this.D = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.f159420d53);
    }

    @Nullable
    private QQCircleRelation$RelationBiz m0(FeedCloudMeta$StRelationInfo feedCloudMeta$StRelationInfo) {
        if (feedCloudMeta$StRelationInfo.busiData.get() == null) {
            return null;
        }
        QQCircleRelation$RelationBiz qQCircleRelation$RelationBiz = new QQCircleRelation$RelationBiz();
        try {
            qQCircleRelation$RelationBiz.mergeFrom(feedCloudMeta$StRelationInfo.busiData.get().toByteArray());
            return qQCircleRelation$RelationBiz;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w("QCircleSpecialFollowUse", 4, "bindData: merge data failed" + e16.toString());
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleSpecialFollowUse";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StRelationInfo feedCloudMeta$StRelationInfo, int i3) {
        boolean isFriend;
        int i16;
        this.C = feedCloudMeta$StRelationInfo.f398459id.get();
        QQCircleRelation$RelationBiz m06 = m0(feedCloudMeta$StRelationInfo);
        int i17 = 0;
        if (m06 != null) {
            this.f93153f.setText(m06.nick.get());
            QLog.i("QCircleSpecialFollowUse", 4, "bindData: " + m06.nick.get() + " " + m06.qqRelation.get() + " " + m06.sign.get() + " " + m06.certification.get());
            this.f93154h.setText(m06.sign.get());
            isFriend = true;
            if (m06.qqRelation.get() != 1) {
                isFriend = false;
            }
            i16 = m06.certification.get();
            this.f93152e.setAvatar(m06.logo.get(), this.C, this.D);
        } else {
            this.f93153f.setText(this.C);
            this.f93154h.setText("");
            isFriend = QCirclePluginUtil.isFriend(this.C);
            i16 = 0;
        }
        URLImageView uRLImageView = this.f93155i;
        if (!isFriend) {
            i17 = 8;
        }
        uRLImageView.setVisibility(i17);
        this.f93152e.setIsAuth(i16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(this.C) && !fb0.a.a("QCircleSpecialFollowUse")) {
            int id5 = view.getId();
            if (id5 != R.id.f32700ug && id5 != R.id.f32730uj) {
                if (id5 == R.id.f32710uh) {
                    QCircleCustomDialog.P(getContext(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f19195467), R.string.cancel, R.string.f170648xe, new a(), new b()).show();
                }
            } else {
                QCircleInitBean qCircleInitBean = new QCircleInitBean();
                qCircleInitBean.setUin(this.C);
                com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setItemBgType(int i3) {
        this.f93151d.setBGType(i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

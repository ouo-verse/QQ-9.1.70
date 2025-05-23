package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedChannelItemView extends QFSMixFeedBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private QQCircleDitto$StItemInfo C;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f90849e;

    /* renamed from: f, reason: collision with root package name */
    private SquareImageView f90850f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90851h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90852i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90853m;

    public QFSMixFeedChannelItemView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        this.f90849e = (LinearLayout) findViewById(R.id.f47191wm);
        this.f90850f = (SquareImageView) findViewById(R.id.f47171wk);
        this.f90851h = (TextView) findViewById(R.id.f47211wo);
        this.f90852i = (TextView) findViewById(R.id.f47181wl);
        TextView textView = (TextView) findViewById(R.id.f47201wn);
        this.f90853m = textView;
        textView.setOnClickListener(this);
    }

    private void l0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        LinearLayout linearLayout = this.f90849e;
        if (linearLayout != null && this.f90853m != null && qQCircleDitto$StItemInfo != null) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_CHANNEL_BANNER);
            VideoReport.setElementId(this.f90853m, QCircleDaTongConstant.ElementId.EM_XSJ_CHANNEL_BANNER_BUTTON);
            HashMap hashMap = new HashMap();
            String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "guild_id");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CHANNEL_ID, valueFromListEntry);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CHANNEL_NAME, QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "channel_name"));
            VideoReport.setElementParams(this.f90849e, hashMap);
            VideoReport.setElementParams(this.f90853m, hashMap);
            VideoReport.setElementReuseIdentifier(this.f90849e, valueFromListEntry);
        }
    }

    private void m0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo.images.size() >= 1 && this.f90850f != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.f90850f).setUrl(qQCircleDitto$StItemInfo.images.get(0).picUrl.get()).setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_skeleton))).setFailDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_skeleton))).setRequestWidth(cx.a(40.0f)).setRequestHeight(cx.a(40.0f)).setPredecode(true));
        } else {
            QLog.i("QFSMixFeedBroadCastItemView", 1, "info.images.size() == 0");
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gj_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedBroadCastItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (qQCircleDitto$StItemInfo != null && qQCircleDitto$StItemInfo.busiInfo.get() != null) {
            this.C = qQCircleDitto$StItemInfo;
            m0(qQCircleDitto$StItemInfo);
            this.f90851h.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "channel_name"));
            this.f90852i.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "channel_desc"));
            this.f90853m.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "go_look_look"));
            l0(qQCircleDitto$StItemInfo);
            return;
        }
        QLog.e("QFSMixFeedBroadCastItemView", 1, "[bindData] stItemInfo == null || info.busiInfo.get() == null");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f47201wn) {
            String f16 = d.f(this.C, ChatsRevealApiImpl.KEY_JUMP_SCHEME);
            if (QCirclePluginUtil.getUrlType(f16) == 0) {
                QCircleHostLauncher.launchChannelPage(r.x(view.getContext()), f16, !QCirclePluginUtil.isTabMode());
            } else {
                com.tencent.biz.qqcircle.launcher.c.g(getContext(), f16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public QFSMixFeedChannelItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSMixFeedChannelItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }
}

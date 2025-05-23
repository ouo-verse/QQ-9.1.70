package com.tencent.biz.qqcircle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleTagItemInfo;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StMedalInfo;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends RecyclerView.Adapter<a> implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    private QCircleReportBean C;
    private Context D;

    /* renamed from: m, reason: collision with root package name */
    private List<QCircleTagItemInfo> f82651m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i3, FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        String str;
        String str2;
        if (getReportBean() != null && getReportBean().getPageId() == 32) {
            QCircleLpReportDc05504.DataBuilder thrActionType = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(13).setThrActionType(i3);
            if (feedCloudMeta$StTagInfo != null && feedCloudMeta$StTagInfo.medal.rank.get() > 0) {
                str = "1";
            } else {
                str = "0";
            }
            QCircleLpReportDc05504.DataBuilder ext2 = thrActionType.setExt2(str);
            if (feedCloudMeta$StTagInfo != null) {
                str2 = feedCloudMeta$StTagInfo.tagName.get();
            } else {
                str2 = "";
            }
            QCircleLpReportDc05504.report(ext2.setExt3(str2).setPageId(getPageId()).setfPageId(getParentPageId()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<QCircleTagItemInfo> list = this.f82651m;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        boolean z16;
        boolean z17;
        List<QCircleTagItemInfo> list = this.f82651m;
        if (list == null || list.size() <= i3) {
            return 1;
        }
        QCircleTagItemInfo qCircleTagItemInfo = this.f82651m.get(i3);
        boolean z18 = false;
        if (qCircleTagItemInfo.getType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (qCircleTagItemInfo.getType() != 3 && qCircleTagItemInfo.getType() != -1) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (qCircleTagItemInfo.getType() == 1 && qCircleTagItemInfo.getTagInfo().medal.rank.get() > 0) {
            z18 = true;
        }
        if (!z16 && !z17 && !z18) {
            return 1;
        }
        return 2;
    }

    protected String getLogTag() {
        return "RANK-QCircleTagListAdapter";
    }

    protected int getPageId() {
        return QCircleReportBean.getPageId(getLogTag(), this.C);
    }

    protected int getParentPageId() {
        return QCircleReportBean.getParentPageId(getLogTag(), this.C);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        aVar.l(this.f82651m.get(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        this.D = viewGroup.getContext();
        if (i3 == 2) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168637g60, viewGroup, false));
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168638g61, viewGroup, false));
    }

    public void setData(List<QCircleTagItemInfo> list) {
        if (list == null) {
            return;
        }
        this.f82651m.clear();
        this.f82651m.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        return QCircleReportBean.getReportBean(getLogTag(), this.C);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView E;
        public ViewGroup F;
        public SquareImageView G;

        a(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.yck);
            this.F = (ViewGroup) view.findViewById(R.id.yov);
            this.G = (SquareImageView) view.findViewById(R.id.yce);
        }

        private void m(int i3) {
            String str;
            if (this.E == null) {
                return;
            }
            VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_TAG);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MEDAL_CONTENT, this.E.getText());
            if (i3 == 5) {
                str = "topic";
            } else if (i3 != 3 && i3 != 4) {
                if (i3 != 1 && i3 != 2) {
                    if (i3 == 7) {
                        str = QCircleDaTongConstant.ElementParamValue.MEDAL_RECOM;
                    } else if (i3 == 8) {
                        str = QCircleDaTongConstant.ElementParamValue.MEDAL_INTERACTION;
                    } else if (i3 == 9) {
                        str = QCircleDaTongConstant.ElementParamValue.MEDAL_NEW_STAR;
                    } else if (i3 == 10) {
                        str = String.valueOf(10);
                    } else {
                        str = null;
                    }
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.MEDAL_BURN_NUM;
                }
            } else {
                str = QCircleDaTongConstant.ElementParamValue.MEDAL_FANS;
            }
            if (str != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MEDAL_TAG, str);
            }
            VideoReport.setElementParams(this.F, buildElementParams);
        }

        private void n(QCircleTagItemInfo qCircleTagItemInfo) {
            FeedCloudMeta$StMedalInfo medalInfo;
            if (qCircleTagItemInfo == null) {
                medalInfo = null;
            } else {
                medalInfo = qCircleTagItemInfo.getMedalInfo();
            }
            if (medalInfo == null) {
                QLog.d("RANK-QCircleTagListAdapter", 1, "[updateNewRankingInfoType] item info should not be null.");
                return;
            }
            this.E.setText(medalInfo.describe.get());
            if (qCircleTagItemInfo.getType() == -1) {
                this.G.setImageResource(R.drawable.na5);
            } else {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(medalInfo.iconUrl.get()).setTargetView(this.G));
            }
            this.F.setOnClickListener(new ViewOnClickListenerC0843a());
        }

        private void o(QCircleTagItemInfo qCircleTagItemInfo) {
            int i3;
            if (qCircleTagItemInfo.getRankingData() == null) {
                return;
            }
            this.E.setText(qCircleTagItemInfo.getRankingData().rankDesc.get());
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qCircleTagItemInfo.getRankingData().rankIconUrl.get()).setTargetView(this.G));
            this.F.setOnClickListener(new b());
            QCircleLpReportDc05504.DataBuilder actionType = new QCircleLpReportDc05504.DataBuilder().setActionType(11);
            if (qCircleTagItemInfo.getRankingData().rankingType.get() == 1) {
                i3 = 53;
            } else {
                i3 = 52;
            }
            QCircleLpReportDc05504.report(actionType.setSubActionType(i3).setThrActionType(1));
        }

        private void p(QCircleTagItemInfo qCircleTagItemInfo) {
            if (qCircleTagItemInfo.getTagInfo() == null) {
                return;
            }
            this.E.setText(qCircleTagItemInfo.getTagInfo().tagName.get());
            if (qCircleTagItemInfo.getTagInfo().medal.has() && qCircleTagItemInfo.getTagInfo().medal.rank.get() > 0) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qCircleTagItemInfo.getTagInfo().tagIconUrl.get()).setTargetView(this.G));
            } else {
                this.G.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(k.this.D, R.drawable.qvideo_skin_icon_general_hashtag_primary));
            }
            this.F.setOnClickListener(new c());
            k.this.n0(4, qCircleTagItemInfo.getTagInfo());
        }

        public void l(QCircleTagItemInfo qCircleTagItemInfo, int i3) {
            if (qCircleTagItemInfo == null) {
                return;
            }
            if (qCircleTagItemInfo.getType() == 2) {
                o(qCircleTagItemInfo);
            } else if (qCircleTagItemInfo.getType() != 3 && qCircleTagItemInfo.getType() != -1) {
                if (qCircleTagItemInfo.getType() == 1) {
                    p(qCircleTagItemInfo);
                } else {
                    this.G.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(k.this.D, R.drawable.qvideo_skin_icon_general_hashtag_primary));
                }
            } else {
                n(qCircleTagItemInfo);
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.F.getLayoutParams();
            if (i3 == 0) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (i3 == k.this.f82651m.size() - 1) {
                layoutParams.setMargins(cx.a(8.0f), 0, cx.a(8.0f), 0);
            } else {
                layoutParams.setMargins(cx.a(8.0f), 0, 0, 0);
            }
            this.F.setLayoutParams(layoutParams);
            m(qCircleTagItemInfo.getMedalInfo().type.get());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.adapter.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class ViewOnClickListenerC0843a implements View.OnClickListener {
            ViewOnClickListenerC0843a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }
    }
}

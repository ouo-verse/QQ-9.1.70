package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.AlphaClickableTextView;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LifeAchivementAdapter extends RecyclerView.Adapter<ViewHolder> {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "LifeAchivementAdapter";
    Context context;
    List<LifeAchivementData> dataList;
    OnItemClickListener itemClickListener;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnItemClickListener {
        void onClickAchivement(View view, int i3);

        void onClickPraise(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;
        private int firstItemLeftSpace;
        private int space;

        public SpacesItemDecoration(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.space = i3;
                this.firstItemLeftSpace = i16;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
                return;
            }
            rect.right = this.space;
            if (recyclerView.getChildPosition(view) == 0) {
                rect.left = this.firstItemLeftSpace;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        public TextView content;
        public AlphaClickableRelativeLayout imageWrapper;
        public LayerImageView imageview;
        public TextView moreNum;
        public AlphaClickableTextView praiseCount;

        public ViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.imageWrapper = (AlphaClickableRelativeLayout) view.findViewById(R.id.xiz);
            this.imageview = (LayerImageView) view.findViewById(R.id.s8o);
            this.moreNum = (TextView) view.findViewById(R.id.s8p);
            this.content = (TextView) view.findViewById(R.id.s8n);
            this.praiseCount = (AlphaClickableTextView) view.findViewById(R.id.s8q);
            this.imageWrapper.enableAlphaClick(false);
            this.praiseCount.setEnabled(true);
        }
    }

    public LifeAchivementAdapter(Context context, List<LifeAchivementData> list, OnItemClickListener onItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, onItemClickListener);
            return;
        }
        this.dataList = new ArrayList();
        this.context = context;
        if (list != null) {
            this.dataList = list;
        }
        this.itemClickListener = onItemClickListener;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "LifeAchivementAdapter itemClickListener = " + this.itemClickListener + ",listener = " + onItemClickListener);
        }
    }

    private void update(ViewHolder viewHolder, LifeAchivementData lifeAchivementData) {
        if (!TextUtils.isEmpty(lifeAchivementData.iconUrl)) {
            URLDrawable drawable = URLDrawable.getDrawable(lifeAchivementData.iconUrl, (URLDrawable.URLDrawableOptions) null);
            if (drawable != null && 1 != drawable.getStatus()) {
                drawable.setAutoDownload(true);
                drawable.startDownload(true);
            }
            viewHolder.imageview.setImageDrawable(drawable);
        }
        int i3 = lifeAchivementData.type;
        if (i3 == 2) {
            viewHolder.moreNum.setVisibility(0);
            viewHolder.moreNum.setText(Marker.ANY_NON_NULL_MARKER + lifeAchivementData.moreNum);
            viewHolder.praiseCount.setVisibility(4);
        } else if (i3 == 1) {
            viewHolder.moreNum.setVisibility(4);
            viewHolder.praiseCount.setVisibility(4);
        } else {
            viewHolder.moreNum.setVisibility(4);
            viewHolder.praiseCount.setVisibility(0);
            updatePraiseUI(viewHolder.praiseCount, lifeAchivementData.hasPraised, lifeAchivementData.praiseNum);
        }
        viewHolder.content.setText(lifeAchivementData.title);
    }

    private void updatePraiseUI(TextView textView, boolean z16, int i3) {
        int i16;
        textView.setText(LifeAchivementHelper.formatPraiseNum(i3));
        if (z16) {
            i16 = R.drawable.nge;
        } else {
            i16 = R.drawable.ngd;
        }
        Drawable drawable = textView.getResources().getDrawable(i16);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
        textView.setCompoundDrawablePadding(Utils.n(2.0f, textView.getResources()));
    }

    public LifeAchivementData getDataByPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LifeAchivementData) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        List<LifeAchivementData> list = this.dataList;
        if (list != null && i3 < list.size()) {
            return this.dataList.get(i3);
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<LifeAchivementData> list = this.dataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void updateDatas(List<LifeAchivementData> list, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (list != null) {
            this.dataList.clear();
            if (i3 > 10) {
                this.dataList.addAll(list.subList(0, 10));
                LifeAchivementData lifeAchivementData = new LifeAchivementData();
                lifeAchivementData.title = this.context.getResources().getString(R.string.f199674q2);
                lifeAchivementData.iconUrl = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
                lifeAchivementData.moreNum = i3 - 10;
                lifeAchivementData.type = 2;
                this.dataList.add(lifeAchivementData);
            } else {
                this.dataList.addAll(list);
            }
            if (z16) {
                LifeAchivementData lifeAchivementData2 = new LifeAchivementData();
                lifeAchivementData2.title = this.context.getResources().getString(R.string.f199614pw);
                lifeAchivementData2.iconUrl = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
                lifeAchivementData2.type = 1;
                this.dataList.add(0, lifeAchivementData2);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            update(viewHolder, this.dataList.get(i3));
            viewHolder.imageview.setOnClickListener(new View.OnClickListener(i3) { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$position;

                {
                    this.val$position = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LifeAchivementAdapter.this, i3);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        OnItemClickListener onItemClickListener = LifeAchivementAdapter.this.itemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onClickAchivement(view, this.val$position);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            viewHolder.praiseCount.setOnClickListener(new View.OnClickListener(i3) { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$position;

                {
                    this.val$position = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LifeAchivementAdapter.this, i3);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        OnItemClickListener onItemClickListener = LifeAchivementAdapter.this.itemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onClickPraise(view, this.val$position);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.h0p, viewGroup, false)) : (ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
    }
}

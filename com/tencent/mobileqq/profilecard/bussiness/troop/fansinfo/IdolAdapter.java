package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.fans.data.a;
import com.tencent.mobileqq.troop.utils.b;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class IdolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "idolAdapter";
    private Context mContext;
    private IdolAdapterCallBack mIdolAdapterCb;
    private List<a.C8682a> mIdolItems;
    private boolean mIsNight;
    private String troopUin;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface IdolAdapterCallBack {
        void gotoWeb();

        void onUpdateItemTheme(TextView textView);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        public URLImageView ivHead;
        public TextView tvName;
        public TextView tvQscore;
        public TextView tvQscoretitle;
        public TextView tvRank;

        MyViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.ivHead = (URLImageView) view.findViewById(R.id.head);
            this.tvQscoretitle = (TextView) view.findViewById(R.id.f6548392);
            this.tvQscore = (TextView) view.findViewById(R.id.f6547391);
            this.tvRank = (TextView) view.findViewById(R.id.f70123kl);
            this.tvName = (TextView) view.findViewById(R.id.f5e);
        }
    }

    public IdolAdapter(Context context, String str, IdolAdapterCallBack idolAdapterCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, idolAdapterCallBack);
            return;
        }
        this.mIdolItems = new ArrayList();
        this.mIsNight = false;
        this.mContext = context;
        this.troopUin = str;
        this.mIdolAdapterCb = idolAdapterCallBack;
        this.mIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    }

    protected void clickItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && i3 < getItemCount()) {
            b.f(this.mContext, this.mIdolItems.get(i3).f295404a, this.troopUin);
            ReportController.o(null, "dc00898", "", "", "0X800B598", "0X800B598", 0, 0, "", "", "", "");
            IdolAdapterCallBack idolAdapterCallBack = this.mIdolAdapterCb;
            if (idolAdapterCallBack != null) {
                idolAdapterCallBack.gotoWeb();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mIdolItems.size();
    }

    public List<a.C8682a> getList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mIdolItems;
    }

    protected String getQScoreText(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 1000000) {
            String format = String.format("%.2f", Double.valueOf((((float) j3) / 10000.0f) - 0.005d));
            if (format.length() > 2 && format.substring(format.length() - 2).equals("00")) {
                format = format.substring(0, format.length() - 3);
            }
            return format + this.mContext.getString(R.string.f20600575);
        }
        return String.valueOf(j3 / 10000) + this.mContext.getString(R.string.f20600575);
    }

    protected String getRankText(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, j3);
        }
        if (j3 <= 0) {
            return this.mContext.getString(R.string.f2068659g);
        }
        return String.format(this.mContext.getString(R.string.f20596571), String.valueOf(j3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, i3);
        } else {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            a.C8682a c8682a = this.mIdolItems.get(i3);
            if (c8682a != null) {
                URLDrawable drawable = URLDrawable.getDrawable(c8682a.f295407d, (URLDrawable.URLDrawableOptions) null);
                if (drawable != null && 1 != drawable.getStatus()) {
                    drawable.restartDownload();
                }
                myViewHolder.ivHead.setImageDrawable(drawable);
                IdolAdapterCallBack idolAdapterCallBack = this.mIdolAdapterCb;
                if (idolAdapterCallBack != null) {
                    idolAdapterCallBack.onUpdateItemTheme(myViewHolder.tvQscoretitle);
                }
                myViewHolder.tvQscore.setText(getQScoreText(c8682a.f295409f));
                myViewHolder.tvRank.setText(getRankText(c8682a.f295408e));
                myViewHolder.tvRank.setContentDescription(getRankText(c8682a.f295408e));
                myViewHolder.tvName.setText(c8682a.f295405b);
                myViewHolder.tvName.setContentDescription(c8682a.f295405b);
                myViewHolder.itemView.setOnClickListener(new View.OnClickListener(i3) { // from class: com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$i;

                    {
                        this.val$i = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IdolAdapter.this, i3);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                        } else {
                            IdolAdapter.this.clickItem(this.val$i);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                if (this.mIsNight) {
                    myViewHolder.itemView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.k6z));
                } else {
                    myViewHolder.itemView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.k6y));
                }
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
        }
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168389fs0, viewGroup, false));
    }

    public void setList(List<a.C8682a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else if (list != null) {
            this.mIdolItems.clear();
            this.mIdolItems.addAll(list);
            notifyDataSetChanged();
        }
    }
}

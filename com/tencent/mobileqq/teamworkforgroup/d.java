package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    public static int C = 2;

    /* renamed from: m, reason: collision with root package name */
    public static int f292584m = 1;

    /* renamed from: d, reason: collision with root package name */
    Context f292585d;

    /* renamed from: f, reason: collision with root package name */
    protected View.OnClickListener f292587f;

    /* renamed from: e, reason: collision with root package name */
    final List<GroupPadTemplateInfo> f292586e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private Set<String> f292588h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private Set<String> f292589i = new HashSet();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public GroupPadTemplateInfo f292592a;

        /* renamed from: b, reason: collision with root package name */
        public AsyncImageView f292593b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f292594c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f292595d;

        /* renamed from: e, reason: collision with root package name */
        public int f292596e;

        public b() {
        }
    }

    public d(Context context, View.OnClickListener onClickListener) {
        this.f292587f = onClickListener;
        this.f292585d = context;
    }

    private void b(AsyncImageView asyncImageView, GroupPadTemplateInfo groupPadTemplateInfo) {
        URLDrawable uRLDrawable;
        if (groupPadTemplateInfo != null) {
            Drawable drawable = this.f292585d.getResources().getDrawable(R.drawable.coc);
            if (!URLUtil.isValidUrl(groupPadTemplateInfo.mobThumbUrl)) {
                asyncImageView.setImageDrawable(drawable);
                return;
            }
            String str = groupPadTemplateInfo.mobThumbUrl;
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            try {
                uRLDrawable = URLDrawable.getDrawable(str, obtain);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("GroupPadTemplateAdapter", 2, e16, "loadThumbImage failed");
                }
                uRLDrawable = null;
            }
            if (uRLDrawable != null) {
                if (uRLDrawable.getStatus() == 2 && this.f292589i.remove(str)) {
                    uRLDrawable.restartDownload();
                }
                uRLDrawable.setDownloadListener(new a(str));
                asyncImageView.setImageDrawable(uRLDrawable);
                if (QLog.isColorLevel()) {
                    QLog.d("GroupPadTemplateAdapter", 2, "loadThumbImage is ok. url: " + str);
                    return;
                }
                return;
            }
            asyncImageView.setImageDrawable(drawable);
            return;
        }
        asyncImageView.setImageResource(R.drawable.coc);
    }

    public GroupPadTemplateInfo c() {
        GroupPadTemplateInfo groupPadTemplateInfo = new GroupPadTemplateInfo();
        groupPadTemplateInfo.docOrSheetType = 1;
        groupPadTemplateInfo.templateName = this.f292585d.getString(R.string.f171013bo3);
        return groupPadTemplateInfo;
    }

    public void d(View.OnClickListener onClickListener) {
        this.f292587f = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f292586e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (i3 >= 0 && i3 < this.f292586e.size()) {
            return this.f292586e.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        if (((GroupPadTemplateInfo) getItem(i3)) != null) {
            return r3.templateID;
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View inflate;
        b bVar;
        GroupPadTemplateInfo groupPadTemplateInfo = (GroupPadTemplateInfo) getItem(i3);
        if (getCount() == i3 + 1) {
            inflate = LayoutInflater.from(this.f292585d).inflate(R.layout.f168015p1, (ViewGroup) null);
            bVar = new b();
            bVar.f292596e = C;
            bVar.f292593b = (AsyncImageView) inflate.findViewById(R.id.cyg);
            bVar.f292594c = (TextView) inflate.findViewById(R.id.cyc);
            bVar.f292595d = (ImageView) inflate.findViewById(R.id.cya);
            bVar.f292592a = groupPadTemplateInfo;
            inflate.setTag(bVar);
            inflate.setOnClickListener(this.f292587f);
        } else {
            inflate = LayoutInflater.from(this.f292585d).inflate(R.layout.f168014p0, (ViewGroup) null);
            bVar = new b();
            bVar.f292596e = f292584m;
            bVar.f292593b = (AsyncImageView) inflate.findViewById(R.id.cyf);
            bVar.f292594c = (TextView) inflate.findViewById(R.id.cye);
            bVar.f292595d = (ImageView) inflate.findViewById(R.id.cy_);
            bVar.f292592a = groupPadTemplateInfo;
            inflate.setTag(bVar);
            inflate.setOnClickListener(this.f292587f);
        }
        if (bVar.f292592a != null) {
            int i16 = bVar.f292596e;
            if (i16 == f292584m) {
                b(bVar.f292593b, groupPadTemplateInfo);
            } else if (i16 == C) {
                bVar.f292593b.setImageResource(R.drawable.cod);
            }
            if (groupPadTemplateInfo != null) {
                bVar.f292594c.setText(groupPadTemplateInfo.templateName);
            }
        } else {
            bVar.f292593b.setImageResource(R.drawable.coc);
            bVar.f292594c.setText("");
        }
        if (AppSetting.f99565y) {
            if (groupPadTemplateInfo != null) {
                inflate.setContentDescription(groupPadTemplateInfo.templateName);
            } else {
                inflate.setContentDescription("");
            }
        }
        EventCollector.getInstance().onListGetView(i3, inflate, viewGroup, getItemId(i3));
        return inflate;
    }

    public void setData(List<GroupPadTemplateInfo> list) {
        this.f292586e.clear();
        if (list != null && list.size() > 0) {
            for (GroupPadTemplateInfo groupPadTemplateInfo : list) {
                if (groupPadTemplateInfo != null && groupPadTemplateInfo.templateID >= 0) {
                    this.f292586e.add(groupPadTemplateInfo);
                }
            }
            this.f292586e.add(c());
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements URLDrawable.DownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f292590d;

        a(String str) {
            this.f292590d = str;
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int i3) {
            if (!d.this.f292588h.contains(this.f292590d)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GroupPadTemplateAdapter", 2, "onFileDownloadFailed url: " + this.f292590d);
                }
                d.this.f292588h.add(this.f292590d);
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long j3) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

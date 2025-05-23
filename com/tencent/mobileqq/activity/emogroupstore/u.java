package com.tencent.mobileqq.activity.emogroupstore;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class u extends RecyclerView.Adapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f182186d;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ImageView f182187d;

        a(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this, (Object) view);
            } else {
                this.f182187d = (ImageView) view.findViewById(R.id.f166904j13);
            }
        }
    }

    public u(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f182186d = arrayList;
        if (list != null) {
            arrayList.clear();
            this.f182186d.addAll(list);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<String> list = this.f182186d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
        } else {
            ImageView imageView = ((a) viewHolder).f182187d;
            if (!TextUtils.isEmpty(this.f182186d.get(i3))) {
                if (i3 == 0) {
                    String str = this.f182186d.get(i3);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mFailedDrawable = drawable;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mPlayGifImage = BaseImageUtil.isGifFile(str);
                    obtain.mUseAutoScaleParams = true;
                    imageView.setImageDrawable(URLDrawable.getFileDrawable(str, obtain));
                } else if (i3 == 1) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0, 0);
                    imageView.setImageDrawable(null);
                    imageView.setBackgroundColor(Color.parseColor("#9A989EB4"));
                } else if (i3 == 2) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0, 0);
                    imageView.setImageDrawable(null);
                    imageView.setBackgroundColor(Color.parseColor("#48989EB4"));
                }
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n3, viewGroup, false));
    }
}

package com.qzone.album.business.photolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.AsyncMarkImageView;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class aa extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f42662d;

    /* renamed from: e, reason: collision with root package name */
    private List<NetImageInfo> f42663e;

    /* renamed from: f, reason: collision with root package name */
    private int f42664f;

    /* renamed from: h, reason: collision with root package name */
    private int f42665h;

    /* renamed from: i, reason: collision with root package name */
    private Context f42666i;

    public aa(List<NetImageInfo> list, Context context) {
        this.f42666i = context;
        if (list != null) {
            this.f42663e = list;
        } else {
            this.f42663e = new ArrayList();
        }
        Context context2 = this.f42666i;
        if (context2 != null) {
            this.f42662d = LayoutInflater.from(context2);
            int dimensionPixelSize = this.f42666i.getResources().getDimensionPixelSize(R.dimen.f158305cp);
            this.f42664f = dimensionPixelSize;
            this.f42665h = dimensionPixelSize;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f42663e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f42663e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f42662d.inflate(R.layout.f169038br4, (ViewGroup) null);
        }
        AsyncMarkImageView asyncMarkImageView = (AsyncMarkImageView) view.findViewById(R.id.c1a);
        asyncMarkImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(this.f42664f, this.f42665h));
        asyncMarkImageView.setAdjustViewBounds(false);
        asyncMarkImageView.setFailImage(R.drawable.asd);
        int i16 = this.f42664f;
        asyncMarkImageView.setAsyncClipSize(i16, i16);
        NetImageInfo netImageInfo = (NetImageInfo) getItem(i3);
        if (netImageInfo != null) {
            asyncMarkImageView.setAsyncImage(netImageInfo.mSmallPath);
        }
        view.setTag(netImageInfo);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}

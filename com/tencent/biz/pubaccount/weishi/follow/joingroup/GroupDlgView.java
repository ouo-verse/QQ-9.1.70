package com.tencent.biz.pubaccount.weishi.follow.joingroup;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GroupDlgView extends RelativeLayout {
    private List<b> C;

    /* renamed from: d, reason: collision with root package name */
    private Context f80722d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f80723e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f80724f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f80725h;

    /* renamed from: i, reason: collision with root package name */
    private a f80726i;

    /* renamed from: m, reason: collision with root package name */
    private WSFollowFeedHolder f80727m;

    public GroupDlgView(Context context, WSFollowFeedHolder wSFollowFeedHolder) {
        super(context);
        this.C = new ArrayList();
        this.f80722d = context;
        this.f80727m = wSFollowFeedHolder;
        LayoutInflater from = LayoutInflater.from(context);
        this.f80723e = from;
        ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.fwf, (ViewGroup) null, false);
        this.f80724f = viewGroup;
        addView(viewGroup);
        this.f80725h = (RecyclerView) this.f80724f.findViewById(R.id.yvn);
        this.f80725h.setLayoutManager(new LinearLayoutManager(this.f80722d));
    }

    public void a(List<b> list) {
        this.C.clear();
        this.C.addAll(list);
        a aVar = new a(this.f80722d, this.C, this.f80727m);
        this.f80726i = aVar;
        this.f80725h.setAdapter(aVar);
    }
}

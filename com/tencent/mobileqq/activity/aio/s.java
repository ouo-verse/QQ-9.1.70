package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class s extends XBaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    protected List<ChatMessage> f179853d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f179854e = false;

    public List<ChatMessage> a() {
        return this.f179853d;
    }

    public int b(ChatMessage chatMessage) {
        List<ChatMessage> list = this.f179853d;
        if (list == null) {
            return -1;
        }
        return list.indexOf(chatMessage);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f179853d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return -1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}

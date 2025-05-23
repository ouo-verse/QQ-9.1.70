package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_recom_tag;
import NS_MOBILE_FEEDS.s_event_tag;
import com.tencent.component.annotation.NeedParcel;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @NeedParcel
    public EventTag f50294a;

    /* renamed from: b, reason: collision with root package name */
    public int f50295b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f50296c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<s_event_tag> f50297d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f50298e;

    /* renamed from: f, reason: collision with root package name */
    public String f50299f;

    /* renamed from: g, reason: collision with root package name */
    public int f50300g;

    public static b a(l lVar) {
        if (lVar == null || lVar.f50361k0 == null) {
            return null;
        }
        b bVar = new b();
        bVar.f50294a = EventTag.create(lVar.f50361k0.tagData);
        cell_recom_tag cell_recom_tagVar = lVar.f50361k0;
        bVar.f50295b = cell_recom_tagVar.action_type;
        bVar.f50296c = cell_recom_tagVar.action_url;
        bVar.f50297d = cell_recom_tagVar.shaishaiTagData;
        bVar.f50298e = cell_recom_tagVar.tianshuEntry;
        bVar.f50299f = cell_recom_tagVar.recomTitle;
        bVar.f50300g = cell_recom_tagVar.recomStyle;
        return bVar;
    }
}

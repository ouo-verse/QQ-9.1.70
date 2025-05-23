package com.tencent.kuikly.core.global;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.z;
import com.tencent.kuikly.core.layout.FlexLayout;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.i;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ListContentView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import okhttp3.HttpUrl;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/global/a;", "", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    public a() {
        BridgeManager bridgeManager = BridgeManager.f117344a;
        new e("{}");
        new com.tencent.kuikly.core.nvi.serialization.json.b(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        c cVar = c.f117352a;
        z zVar = z.f117226a;
        com.tencent.kuikly.core.coroutines.e eVar = com.tencent.kuikly.core.coroutines.e.f117232d;
        g.Companion companion = g.INSTANCE;
        i iVar = i.f117392a;
        Reflection.getOrCreateKotlinClass(InnerPagerClassLoader.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(v.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(aq.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(ListContentView.class).getSimpleName();
        new ao();
        new m();
        new Event();
        new Attr();
        Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(TextView.class).getSimpleName();
        new l();
        Reflection.getOrCreateKotlinClass(RichTextView.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(ImageView.class).getSimpleName();
        new af();
        new ce();
        Reflection.getOrCreateKotlinClass(ButtonView.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(PageListView.class).getSimpleName();
        Reflection.getOrCreateKotlinClass(m01.b.class).getSimpleName();
        ReactiveObserver.Companion companion2 = ReactiveObserver.INSTANCE;
        new BaseObject();
        new FlexLayout();
        new FlexNode();
        new com.tencent.kuikly.core.layout.c();
        new com.tencent.kuikly.core.layout.b();
        com.tencent.kuikly.core.layout.e eVar2 = com.tencent.kuikly.core.layout.e.f117328a;
        new com.tencent.kuikly.core.layout.a();
        Reflection.getOrCreateKotlinClass(GlobalFunctions.class).getSimpleName();
        KLog kLog = KLog.INSTANCE;
        h.Companion companion3 = h.INSTANCE;
        com.tencent.kuikly.core.utils.a aVar = com.tencent.kuikly.core.utils.a.f118267a;
    }
}

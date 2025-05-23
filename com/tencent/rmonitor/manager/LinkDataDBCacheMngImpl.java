package com.tencent.rmonitor.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.reporter.link.LinkData;
import com.tencent.bugly.common.reporter.link.LinkDataDBCacheMng;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/rmonitor/manager/LinkDataDBCacheMngImpl;", "Lcom/tencent/bugly/common/reporter/link/LinkDataDBCacheMng;", "Lcom/tencent/rmonitor/base/db/d;", "b", "Lcom/tencent/rmonitor/base/db/a;", "d", "", "launchID", "processLaunchID", "Ljava/util/ArrayList;", "Lcom/tencent/bugly/common/reporter/link/LinkData;", "Lkotlin/collections/ArrayList;", "c", "linkData", "", "saveToDB", "", "a", "I", "maxReadDataCount", "Lcom/tencent/rmonitor/base/db/d;", "dbHelper", "Ljava/lang/String;", "productID", "<init>", "(Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LinkDataDBCacheMngImpl implements LinkDataDBCacheMng {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxReadDataCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.rmonitor.base.db.d dbHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String productID;

    public LinkDataDBCacheMngImpl(@NotNull String productID) {
        Intrinsics.checkParameterIsNotNull(productID, "productID");
        this.productID = productID;
        this.maxReadDataCount = 1000;
    }

    private final com.tencent.rmonitor.base.db.d b() {
        com.tencent.rmonitor.base.db.c dbHandler;
        Context globalContext = ContextUtil.getGlobalContext();
        if (this.dbHelper == null && globalContext != null) {
            d.Companion companion = com.tencent.rmonitor.base.db.d.INSTANCE;
            Context globalContext2 = ContextUtil.getGlobalContext();
            Intrinsics.checkExpressionValueIsNotNull(globalContext2, "ContextUtil.getGlobalContext()");
            com.tencent.rmonitor.base.db.d a16 = companion.a(globalContext2);
            this.dbHelper = a16;
            if (a16 != null && (dbHandler = a16.getDbHandler()) != null) {
                dbHandler.i();
            }
        }
        return this.dbHelper;
    }

    private final com.tencent.rmonitor.base.db.a d() {
        Context globalContext = ContextUtil.getGlobalContext();
        com.tencent.rmonitor.base.db.a aVar = new com.tencent.rmonitor.base.db.a();
        aVar.f365359b = com.tencent.rmonitor.common.util.a.INSTANCE.c(globalContext);
        aVar.f365358a = this.productID;
        aVar.f365362e = TraceGenerator.getLaunchId(globalContext);
        aVar.f365363f = TraceGenerator.getProcessLaunchId();
        return aVar;
    }

    @Override // com.tencent.bugly.common.reporter.link.LinkDataDBCacheMng
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ArrayList<LinkData> loadFromDB(@Nullable String launchID, @Nullable String processLaunchID) {
        if (!TextUtils.isEmpty(launchID) && !TextUtils.isEmpty(processLaunchID)) {
            com.tencent.rmonitor.base.db.d b16 = b();
            if (b16 == null) {
                Logger.f365497g.e("RMonitor_link", "load from db fail for db helper is null.");
                return null;
            }
            com.tencent.rmonitor.base.db.a d16 = d();
            d16.f365362e = launchID;
            d16.f365363f = processLaunchID;
            Object m3 = b16.getDbHandler().m(new com.tencent.rmonitor.base.db.table.b(d16), new Function0<Integer>() { // from class: com.tencent.rmonitor.manager.LinkDataDBCacheMngImpl$loadFromDB$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    int i3;
                    i3 = LinkDataDBCacheMngImpl.this.maxReadDataCount;
                    return i3;
                }
            });
            if (m3 != null) {
                return (ArrayList) m3;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.bugly.common.reporter.link.LinkData> /* = java.util.ArrayList<com.tencent.bugly.common.reporter.link.LinkData> */");
        }
        Logger.f365497g.e("RMonitor_link", "load from db fail for invalid params.");
        return null;
    }

    @Override // com.tencent.bugly.common.reporter.link.LinkDataDBCacheMng
    public boolean saveToDB(@Nullable LinkData linkData) {
        if (linkData == null) {
            return false;
        }
        com.tencent.rmonitor.base.db.d b16 = b();
        if (b16 == null) {
            Logger.f365497g.e("RMonitor_link", "save record {" + linkData.subType + ", " + linkData.clientIdentify + "} to db fail for db helper is null.");
            return false;
        }
        int h16 = b16.getDbHandler().h(new com.tencent.rmonitor.base.db.table.b(d(), linkData), new Function0<Integer>() { // from class: com.tencent.rmonitor.manager.LinkDataDBCacheMngImpl$saveToDB$ret$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return 0;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }
        });
        if (h16 == -1 || h16 == -2) {
            Logger.f365497g.e("RMonitor_link", "save record {" + linkData.subType + ", " + linkData.clientIdentify + "} to db fail for ret = " + h16);
        }
        if (h16 == -1 || h16 == -2) {
            return false;
        }
        return true;
    }
}

package com.tencent.tmdownloader.f.b.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.tmdownloader.internal.storage.table.b;
import com.tencent.tmdownloader.internal.storage.table.d;
import com.tencent.tmdownloader.internal.storage.table.e;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static volatile c f380655a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f380656b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f380656b = new Class[]{com.tencent.tmdownloader.internal.storage.table.c.class, d.class, b.class, CacheTable.class, com.tencent.tmassistantsdk.a.c.a.a.class, e.class, com.tencent.replacemonitor.replace.d.b.class};
        }
    }

    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, cursorFactory, Integer.valueOf(i3));
        }
    }

    public static c c() {
        Context context;
        if (f380655a == null) {
            synchronized (a.class) {
                if (f380655a == null && (context = GlobalUtil.getInstance().getContext()) != null) {
                    f380655a = new a(context, "tmassistant_sdk_v2.db", null, 8);
                }
            }
        }
        return f380655a;
    }

    @Override // com.tencent.tmassistant.common.a.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // com.tencent.tmassistant.common.a.c
    public Class<?>[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f380656b;
    }
}

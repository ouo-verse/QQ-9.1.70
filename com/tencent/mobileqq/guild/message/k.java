package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.data.ChannelMsgEventCollection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f230582d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f230583e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f230584f;

    static {
        int i3 = 0 + 1;
        f230582d = i3 + 1;
        f230584f = i3;
    }

    private void c(int i3, boolean z16, Object obj) {
        if (i3 != f230584f) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    a(z16, (List) obj2);
                    return;
                }
            }
            a(false, null);
            return;
        }
        a(false, null);
    }

    private void d(int i3, boolean z16, Object obj) {
        if (i3 != f230583e) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    b(z16, (List) obj2);
                    return;
                }
            }
            b(false, null);
            return;
        }
        b(false, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        d(i3, z16, obj);
        c(i3, z16, obj);
    }

    protected void a(boolean z16, List<ChannelMsgEventCollection> list) {
    }

    protected void b(boolean z16, List<ChannelMsgEventCollection> list) {
    }
}

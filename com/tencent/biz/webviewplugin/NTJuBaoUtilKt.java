package com.tencent.biz.webviewplugin;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a<\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u001a\u0010\t\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0005H\u0002\u00a8\u0006\u000b"}, d2 = {"", "chatType", "", "chatUin", "maxCount", "Lkotlin/Function1;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "callback", "b", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class NTJuBaoUtilKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, String str, int i16, Function1<? super List<MsgRecord>, Unit> function1) {
        com.tencent.nt.adapter.session.c.j(str, i3, new NTJuBaoUtilKt$getMsgRecords$1(i16, function1));
    }
}

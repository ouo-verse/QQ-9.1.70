package com.tencent.mobileqq.wink.editor.export.compress;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tav.core.ExportConfig;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c extends com.tencent.mobileqq.wink.editor.export.compress.base.c {

    /* renamed from: d, reason: collision with root package name */
    private WinkVideoEncodeThread f320208d;

    /* renamed from: e, reason: collision with root package name */
    private WinkVideoDecodeThread f320209e;

    /* renamed from: f, reason: collision with root package name */
    private WinkAudioProcessThread f320210f;

    /* renamed from: g, reason: collision with root package name */
    private WinkMuxerThread f320211g;

    private void n(final String str, final String str2, final ExportConfig exportConfig) {
        RFWThreadManager.createNewThreadHandler("WinkVideoCompress", 0).post(new Runnable() { // from class: n63.f
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.editor.export.compress.c.this.p(str, str2, exportConfig);
            }
        });
    }

    private int o(String str) {
        int x16 = j.x(str);
        if (x16 <= 0) {
            int h16 = a.h(str);
            QLog.d(b(), 1, "getAveFrameRate = " + h16);
            if (h16 <= 0) {
                return 30;
            }
            return h16;
        }
        return x16;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v71 ??, still in use, count: 2, list:
          (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread) from 0x027d: IPUT 
          (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread)
          (r11v17 ?? I:com.tencent.mobileqq.wink.editor.export.compress.c)
         A[Catch: Exception -> 0x03d1] com.tencent.mobileqq.wink.editor.export.compress.c.f com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread
          (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread) from 0x027f: INVOKE (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread), (r2v18 ?? I:n63.a) VIRTUAL call: com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread.p(n63.a):void A[Catch: Exception -> 0x03d1, MD:(n63.a):void (m)] (LINE:42)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v71 ??, still in use, count: 2, list:
          (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread) from 0x027d: IPUT 
          (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread)
          (r11v17 ?? I:com.tencent.mobileqq.wink.editor.export.compress.c)
         A[Catch: Exception -> 0x03d1] com.tencent.mobileqq.wink.editor.export.compress.c.f com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread
          (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread) from 0x027f: INVOKE (r0v71 ?? I:com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread), (r2v18 ?? I:n63.a) VIRTUAL call: com.tencent.mobileqq.wink.editor.export.compress.WinkAudioProcessThread.p(n63.a):void A[Catch: Exception -> 0x03d1, MD:(n63.a):void (m)] (LINE:42)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r39v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c, com.tencent.mobileqq.wink.editor.export.compress.base.a
    public String b() {
        return super.b() + "WinkVideoCompressProcessor";
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c, com.tencent.mobileqq.wink.editor.export.compress.base.a
    public void cancel() {
        super.cancel();
        WinkVideoEncodeThread winkVideoEncodeThread = this.f320208d;
        if (winkVideoEncodeThread != null) {
            winkVideoEncodeThread.cancel();
        }
        WinkVideoDecodeThread winkVideoDecodeThread = this.f320209e;
        if (winkVideoDecodeThread != null) {
            winkVideoDecodeThread.cancel();
        }
        WinkAudioProcessThread winkAudioProcessThread = this.f320210f;
        if (winkAudioProcessThread != null) {
            winkAudioProcessThread.cancel();
        }
        WinkMuxerThread winkMuxerThread = this.f320211g;
        if (winkMuxerThread != null) {
            winkMuxerThread.cancel();
        }
        d();
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c
    public void l(@NonNull String str, @NonNull String str2, @NonNull ExportConfig exportConfig) {
        n(str, str2, exportConfig);
    }

    public void q() {
        WinkVideoEncodeThread winkVideoEncodeThread = this.f320208d;
        if (winkVideoEncodeThread != null) {
            winkVideoEncodeThread.cancel();
        }
        WinkVideoDecodeThread winkVideoDecodeThread = this.f320209e;
        if (winkVideoDecodeThread != null) {
            winkVideoDecodeThread.cancel();
        }
        WinkAudioProcessThread winkAudioProcessThread = this.f320210f;
        if (winkAudioProcessThread != null) {
            winkAudioProcessThread.cancel();
        }
        WinkMuxerThread winkMuxerThread = this.f320211g;
        if (winkMuxerThread != null) {
            winkMuxerThread.cancel();
        }
    }
}

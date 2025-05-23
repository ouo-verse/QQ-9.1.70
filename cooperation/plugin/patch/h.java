package cooperation.plugin.patch;

import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.shadow.patch.ApkPatch;
import cooperation.plugin.patch.ZipPatcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    private static final String f390363b = MobileQQ.sMobileQQ.getFilesDir().getPath() + File.separator + "patch_so/libapkpatch.so";

    /* renamed from: a, reason: collision with root package name */
    private boolean f390364a = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements ZipPatcher.b {
        a() {
        }

        @Override // cooperation.plugin.patch.ZipPatcher.b
        public boolean a() {
            return false;
        }

        @Override // cooperation.plugin.patch.ZipPatcher.b
        public Object b(Object obj, Object obj2, Object obj3) {
            if (ApkPatch.patch((String) obj, (String) obj2, (String) obj3) != 0) {
                return null;
            }
            return obj3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements ZipPatcher.c {
        b() {
        }

        @Override // cooperation.plugin.patch.ZipPatcher.c
        public boolean a() {
            return false;
        }

        @Override // cooperation.plugin.patch.ZipPatcher.c
        public Object b(Object obj, Object obj2) {
            if (ApkPatch.normalizeZip((String) obj, (String) obj2)) {
                return obj2;
            }
            return null;
        }
    }

    static {
        ZipPatcher.INSTANCE.d("p", new a());
    }

    private void a(String str, String str2) throws IOException {
        String str3;
        if (this.f390364a) {
            return;
        }
        cooperation.plugin.patch.b d16 = new ZipExtractor(new QZipInputStream(new FileInputStream(str)), str2).d("libapkpatch.so");
        if (d16 != null) {
            str3 = (String) d16.a();
        } else {
            str3 = null;
        }
        b(new File(str3));
    }

    private void b(File file) throws IOException {
        String str = f390363b;
        File createFile = FileUtils.createFile(str);
        if (FileUtils.isEmptyFile(str)) {
            FileUtils.copyFile(file, createFile);
        } else if (!com.tencent.qqprotect.singleupdate.a.d(file).equalsIgnoreCase(com.tencent.qqprotect.singleupdate.a.d(createFile))) {
            FileUtils.copyFile(file, createFile);
        }
        this.f390364a = ApkPatch.loadSo(str);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v0 ??, still in use, count: 1, list:
          (r15v0 ?? I:cooperation.plugin.patch.ZipPatcher) from 0x0086: INVOKE (r15v0 ?? I:cooperation.plugin.patch.ZipPatcher), (r18v0 ?? I:java.lang.String) VIRTUAL call: cooperation.plugin.patch.ZipPatcher.l(java.lang.String):void A[Catch: all -> 0x00ab, IOException -> 0x00ae, MD:(java.lang.String):void throws java.io.IOException (m)] (LINE:135)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public void c(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v0 ??, still in use, count: 1, list:
          (r15v0 ?? I:cooperation.plugin.patch.ZipPatcher) from 0x0086: INVOKE (r15v0 ?? I:cooperation.plugin.patch.ZipPatcher), (r18v0 ?? I:java.lang.String) VIRTUAL call: cooperation.plugin.patch.ZipPatcher.l(java.lang.String):void A[Catch: all -> 0x00ab, IOException -> 0x00ae, MD:(java.lang.String):void throws java.io.IOException (m)] (LINE:135)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r17v0 ??
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
}

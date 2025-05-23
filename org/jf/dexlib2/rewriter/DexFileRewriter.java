package org.jf.dexlib2.rewriter;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexFileRewriter implements Rewriter<DexFile> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenDexFile implements DexFile {

        @Nonnull
        protected final DexFile dexFile;

        public RewrittenDexFile(@Nonnull DexFile dexFile) {
            this.dexFile = dexFile;
        }

        @Override // org.jf.dexlib2.iface.DexFile
        @Nonnull
        public Set<? extends ClassDef> getClasses() {
            return RewriterUtils.rewriteSet(DexFileRewriter.this.rewriters.getClassDefRewriter(), this.dexFile.getClasses());
        }

        @Override // org.jf.dexlib2.iface.DexFile
        @Nonnull
        public Opcodes getOpcodes() {
            return this.dexFile.getOpcodes();
        }
    }

    public DexFileRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public DexFile rewrite(@Nonnull DexFile dexFile) {
        return new RewrittenDexFile(dexFile);
    }
}

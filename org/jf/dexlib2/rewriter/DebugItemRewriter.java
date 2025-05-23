package org.jf.dexlib2.rewriter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.debug.EndLocal;
import org.jf.dexlib2.iface.debug.LocalInfo;
import org.jf.dexlib2.iface.debug.RestartLocal;
import org.jf.dexlib2.iface.debug.StartLocal;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DebugItemRewriter implements Rewriter<DebugItem> {

    @Nonnull
    protected final Rewriters rewriters;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    protected class BaseRewrittenLocalInfoDebugItem<T extends DebugItem & LocalInfo> implements DebugItem, LocalInfo {

        @Nonnull
        protected T debugItem;

        public BaseRewrittenLocalInfoDebugItem(@Nonnull T t16) {
            this.debugItem = t16;
        }

        @Override // org.jf.dexlib2.iface.debug.DebugItem
        public int getCodeAddress() {
            return this.debugItem.getCodeAddress();
        }

        @Override // org.jf.dexlib2.iface.debug.DebugItem
        public int getDebugItemType() {
            return this.debugItem.getDebugItemType();
        }

        @Override // org.jf.dexlib2.iface.debug.LocalInfo
        @Nullable
        public String getName() {
            return this.debugItem.getName();
        }

        @Override // org.jf.dexlib2.iface.debug.LocalInfo
        @Nullable
        public String getSignature() {
            return this.debugItem.getSignature();
        }

        @Override // org.jf.dexlib2.iface.debug.LocalInfo
        @Nullable
        public String getType() {
            return (String) RewriterUtils.rewriteNullable(DebugItemRewriter.this.rewriters.getTypeRewriter(), this.debugItem.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenEndLocal extends BaseRewrittenLocalInfoDebugItem<EndLocal> implements EndLocal {
        public RewrittenEndLocal(@Nonnull EndLocal endLocal) {
            super(endLocal);
        }

        @Override // org.jf.dexlib2.iface.debug.EndLocal
        public int getRegister() {
            return ((EndLocal) this.debugItem).getRegister();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenRestartLocal extends BaseRewrittenLocalInfoDebugItem<RestartLocal> implements RestartLocal {
        public RewrittenRestartLocal(@Nonnull RestartLocal restartLocal) {
            super(restartLocal);
        }

        @Override // org.jf.dexlib2.iface.debug.RestartLocal
        public int getRegister() {
            return ((RestartLocal) this.debugItem).getRegister();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenStartLocal extends BaseRewrittenLocalInfoDebugItem<StartLocal> implements StartLocal {
        public RewrittenStartLocal(@Nonnull StartLocal startLocal) {
            super(startLocal);
        }

        @Override // org.jf.dexlib2.iface.debug.StartLocal
        @Nullable
        public StringReference getNameReference() {
            return ((StartLocal) this.debugItem).getNameReference();
        }

        @Override // org.jf.dexlib2.iface.debug.StartLocal
        public int getRegister() {
            return ((StartLocal) this.debugItem).getRegister();
        }

        @Override // org.jf.dexlib2.iface.debug.StartLocal
        @Nullable
        public StringReference getSignatureReference() {
            return ((StartLocal) this.debugItem).getSignatureReference();
        }

        @Override // org.jf.dexlib2.iface.debug.StartLocal
        @Nullable
        public TypeReference getTypeReference() {
            TypeReference typeReference = ((StartLocal) this.debugItem).getTypeReference();
            if (typeReference == null) {
                return null;
            }
            return RewriterUtils.rewriteTypeReference(DebugItemRewriter.this.rewriters.getTypeRewriter(), typeReference);
        }
    }

    public DebugItemRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public DebugItem rewrite(@Nonnull DebugItem debugItem) {
        int debugItemType = debugItem.getDebugItemType();
        if (debugItemType == 3) {
            return new RewrittenStartLocal((StartLocal) debugItem);
        }
        if (debugItemType != 5) {
            return debugItemType != 6 ? debugItem : new RewrittenRestartLocal((RestartLocal) debugItem);
        }
        return new RewrittenEndLocal((EndLocal) debugItem);
    }
}

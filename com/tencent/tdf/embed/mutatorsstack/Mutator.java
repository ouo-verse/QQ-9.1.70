package com.tencent.tdf.embed.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Mutator {
    static IPatchRedirector $redirector_;
    private Matrix matrix;
    private Path path;
    private float[] radiis;
    private RectF rect;
    private EmbeddedMutatorType type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class EmbeddedMutatorType {
        private static final /* synthetic */ EmbeddedMutatorType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final EmbeddedMutatorType CLIP_PATH;
        public static final EmbeddedMutatorType CLIP_RECT;
        public static final EmbeddedMutatorType CLIP_RRECT;
        public static final EmbeddedMutatorType OPACITY;
        public static final EmbeddedMutatorType TRANSFORM;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15017);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EmbeddedMutatorType embeddedMutatorType = new EmbeddedMutatorType("CLIP_RECT", 0);
            CLIP_RECT = embeddedMutatorType;
            EmbeddedMutatorType embeddedMutatorType2 = new EmbeddedMutatorType("CLIP_RRECT", 1);
            CLIP_RRECT = embeddedMutatorType2;
            EmbeddedMutatorType embeddedMutatorType3 = new EmbeddedMutatorType("CLIP_PATH", 2);
            CLIP_PATH = embeddedMutatorType3;
            EmbeddedMutatorType embeddedMutatorType4 = new EmbeddedMutatorType("TRANSFORM", 3);
            TRANSFORM = embeddedMutatorType4;
            EmbeddedMutatorType embeddedMutatorType5 = new EmbeddedMutatorType("OPACITY", 4);
            OPACITY = embeddedMutatorType5;
            $VALUES = new EmbeddedMutatorType[]{embeddedMutatorType, embeddedMutatorType2, embeddedMutatorType3, embeddedMutatorType4, embeddedMutatorType5};
        }

        EmbeddedMutatorType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static EmbeddedMutatorType valueOf(String str) {
            return (EmbeddedMutatorType) Enum.valueOf(EmbeddedMutatorType.class, str);
        }

        public static EmbeddedMutatorType[] values() {
            return (EmbeddedMutatorType[]) $VALUES.clone();
        }
    }

    public Mutator(RectF rectF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rectF);
        } else {
            this.type = EmbeddedMutatorType.CLIP_RECT;
            this.rect = this.rect;
        }
    }

    public Matrix getMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Matrix) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.matrix;
    }

    public Path getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Path) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.path;
    }

    public RectF getRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RectF) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.rect;
    }

    public EmbeddedMutatorType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EmbeddedMutatorType) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.type;
    }

    public Mutator(RectF rectF, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rectF, (Object) fArr);
            return;
        }
        this.type = EmbeddedMutatorType.CLIP_RRECT;
        this.rect = rectF;
        this.radiis = fArr;
    }

    public Mutator(Path path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
        } else {
            this.type = EmbeddedMutatorType.CLIP_PATH;
            this.path = path;
        }
    }

    public Mutator(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) matrix);
        } else {
            this.type = EmbeddedMutatorType.TRANSFORM;
            this.matrix = matrix;
        }
    }
}

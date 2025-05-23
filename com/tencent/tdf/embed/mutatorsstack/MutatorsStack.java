package com.tencent.tdf.embed.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutatorsStack {
    static IPatchRedirector $redirector_;
    private List<Path> finalClippingPaths;
    private Matrix finalMatrix;
    private List<Mutator> mutators;

    public MutatorsStack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mutators = new ArrayList();
        this.finalMatrix = new Matrix();
        this.finalClippingPaths = new ArrayList();
    }

    public List<Path> getFinalClippingPaths() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Matrix) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.finalMatrix;
    }

    public List<Mutator> getMutators() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mutators;
    }

    public void pushClipRRect(float f16, float f17, float f18, float f19, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), fArr);
            return;
        }
        RectF rectF = new RectF(f16, f17, f18, f19);
        this.mutators.add(new Mutator(rectF, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rectF), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        RectF rectF = new RectF(f16, f17, f18, f19);
        this.mutators.add(new Mutator(rectF));
        Path path = new Path();
        path.addRect(new RectF(rectF), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushTransform(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fArr);
            return;
        }
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        Mutator mutator = new Mutator(matrix);
        this.mutators.add(mutator);
        this.finalMatrix.preConcat(mutator.getMatrix());
    }
}

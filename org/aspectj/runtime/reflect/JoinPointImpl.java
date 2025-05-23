package org.aspectj.runtime.reflect;

import java.util.Stack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;

/* loaded from: classes29.dex */
class JoinPointImpl implements ProceedingJoinPoint {
    Object _this;
    private AroundClosure arc = null;
    private Stack<AroundClosure> arcs = null;
    Object[] args;
    JoinPoint.StaticPart staticPart;
    Object target;

    /* loaded from: classes29.dex */
    static class EnclosingStaticPartImpl extends StaticPartImpl implements JoinPoint.EnclosingStaticPart {
        public EnclosingStaticPartImpl(int i3, String str, Signature signature, SourceLocation sourceLocation) {
            super(i3, str, signature, sourceLocation);
        }
    }

    public JoinPointImpl(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        this.staticPart = staticPart;
        this._this = obj;
        this.target = obj2;
        this.args = objArr;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object[] getArgs() {
        if (this.args == null) {
            this.args = new Object[0];
        }
        Object[] objArr = this.args;
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return objArr2;
    }

    @Override // org.aspectj.lang.JoinPoint
    public String getKind() {
        return this.staticPart.getKind();
    }

    @Override // org.aspectj.lang.JoinPoint
    public Signature getSignature() {
        return this.staticPart.getSignature();
    }

    @Override // org.aspectj.lang.JoinPoint
    public SourceLocation getSourceLocation() {
        return this.staticPart.getSourceLocation();
    }

    @Override // org.aspectj.lang.JoinPoint
    public JoinPoint.StaticPart getStaticPart() {
        return this.staticPart;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object getTarget() {
        return this.target;
    }

    @Override // org.aspectj.lang.JoinPoint
    public Object getThis() {
        return this._this;
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public Object proceed() throws Throwable {
        Stack<AroundClosure> stack = this.arcs;
        if (stack == null) {
            AroundClosure aroundClosure = this.arc;
            if (aroundClosure == null) {
                return null;
            }
            return aroundClosure.run(aroundClosure.getState());
        }
        return stack.peek().run(this.arcs.peek().getState());
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public void set$AroundClosure(AroundClosure aroundClosure) {
        this.arc = aroundClosure;
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public void stack$AroundClosure(AroundClosure aroundClosure) {
        if (this.arcs == null) {
            this.arcs = new Stack<>();
        }
        if (aroundClosure == null) {
            this.arcs.pop();
        } else {
            this.arcs.push(aroundClosure);
        }
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toLongString() {
        return this.staticPart.toLongString();
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toShortString() {
        return this.staticPart.toShortString();
    }

    @Override // org.aspectj.lang.JoinPoint
    public final String toString() {
        return this.staticPart.toString();
    }

    @Override // org.aspectj.lang.ProceedingJoinPoint
    public Object proceed(Object[] objArr) throws Throwable {
        AroundClosure peek;
        int i3;
        Stack<AroundClosure> stack = this.arcs;
        if (stack == null) {
            peek = this.arc;
        } else {
            peek = stack.peek();
        }
        if (peek == null) {
            return null;
        }
        int flags = peek.getFlags();
        boolean z16 = (65536 & flags) != 0;
        int i16 = (flags & 4096) != 0 ? 1 : 0;
        int i17 = (flags & 256) != 0 ? 1 : 0;
        boolean z17 = (flags & 16) != 0;
        boolean z18 = (flags & 1) != 0;
        Object[] state = peek.getState();
        int i18 = i16 + 0 + ((!z17 || z16) ? 0 : 1);
        if (i16 == 0 || i17 == 0) {
            i3 = 0;
        } else {
            state[0] = objArr[0];
            i3 = 1;
        }
        if (z17 && z18) {
            if (z16) {
                i3 = i17 + 1;
                state[0] = objArr[i17];
            } else {
                char c16 = (i16 == 0 || i17 == 0) ? (char) 0 : (char) 1;
                int i19 = (i16 == 0 || i17 == 0) ? 0 : 1;
                int i26 = (z17 && z18 && !z16) ? 1 : 0;
                state[i16] = objArr[c16];
                i3 = i19 + i26;
            }
        }
        for (int i27 = i3; i27 < objArr.length; i27++) {
            state[(i27 - i3) + i18] = objArr[i27];
        }
        return peek.run(state);
    }

    /* loaded from: classes29.dex */
    static class StaticPartImpl implements JoinPoint.StaticPart {

        /* renamed from: id, reason: collision with root package name */
        private int f423555id;
        String kind;
        Signature signature;
        SourceLocation sourceLocation;

        public StaticPartImpl(int i3, String str, Signature signature, SourceLocation sourceLocation) {
            this.kind = str;
            this.signature = signature;
            this.sourceLocation = sourceLocation;
            this.f423555id = i3;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public int getId() {
            return this.f423555id;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public String getKind() {
            return this.kind;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public Signature getSignature() {
            return this.signature;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public SourceLocation getSourceLocation() {
            return this.sourceLocation;
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toLongString() {
            return toString(StringMaker.longStringMaker);
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toShortString() {
            return toString(StringMaker.shortStringMaker);
        }

        String toString(StringMaker stringMaker) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stringMaker.makeKindName(getKind()));
            stringBuffer.append("(");
            stringBuffer.append(((SignatureImpl) getSignature()).toString(stringMaker));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        @Override // org.aspectj.lang.JoinPoint.StaticPart
        public final String toString() {
            return toString(StringMaker.middleStringMaker);
        }
    }
}

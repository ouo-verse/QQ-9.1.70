package com.tencent.ams.fusion.widget.tma.slidecalculate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideConfig {
    static IPatchRedirector $redirector_;
    private int degreeA;
    private int degreeB;
    private Integer degreeC;
    private Integer degreeD;
    private int degreeN;
    private int distance;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private int degreeA;
        private int degreeB;
        private Integer degreeC;
        private Integer degreeD;
        private int degreeN;
        private int distance;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.degreeA = 90;
            this.degreeB = 0;
            this.degreeC = null;
            this.degreeD = null;
            this.degreeN = 45;
            this.distance = 200;
        }

        private boolean invalidRange(int i3) {
            if (i3 >= 0 && i3 <= 360) {
                return false;
            }
            return true;
        }

        private void resetDegree() {
            if (this.degreeA == 360) {
                this.degreeA = 0;
            }
            if (this.degreeB == 360) {
                this.degreeB = 0;
            }
            Integer num = this.degreeC;
            if (num != null && num.intValue() == 360) {
                this.degreeC = 0;
            }
            Integer num2 = this.degreeD;
            if (num2 != null && num2.intValue() == 360) {
                this.degreeD = 0;
            }
        }

        public SlideConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (SlideConfig) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            if (invalidRange(this.degreeA) || invalidRange(this.degreeB)) {
                this.degreeA = 90;
                this.degreeB = 0;
            }
            Integer num = this.degreeD;
            AnonymousClass1 anonymousClass1 = null;
            if ((num == null && this.degreeC != null) || (num != null && this.degreeC == null)) {
                this.degreeC = null;
                this.degreeD = null;
            } else {
                Integer num2 = this.degreeC;
                if (num2 != null && (invalidRange(num2.intValue()) || invalidRange(this.degreeD.intValue()))) {
                    this.degreeC = null;
                    this.degreeD = null;
                }
            }
            if (invalidRange(this.degreeN)) {
                this.degreeN = 45;
            }
            if (this.distance < 0) {
                this.distance = 200;
            }
            resetDegree();
            return new SlideConfig(this, anonymousClass1);
        }

        public Builder degreeA(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.degreeA = i3;
            return this;
        }

        public Builder degreeB(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.degreeB = i3;
            return this;
        }

        public Builder degreeC(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) num);
            }
            this.degreeC = num;
            return this;
        }

        public Builder degreeD(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
            }
            this.degreeD = num;
            return this;
        }

        public Builder degreeN(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.degreeN = i3;
            return this;
        }

        public Builder distance(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.distance = i3;
            return this;
        }
    }

    /* synthetic */ SlideConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    private void setDegreeA(int i3) {
        this.degreeA = i3;
    }

    private void setDegreeB(int i3) {
        this.degreeB = i3;
    }

    private void setDegreeC(Integer num) {
        this.degreeC = num;
    }

    private void setDegreeD(Integer num) {
        this.degreeD = num;
    }

    private void setDegreeN(int i3) {
        this.degreeN = i3;
    }

    private void setDistance(int i3) {
        this.distance = i3;
    }

    public int getDegreeA() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.degreeA;
    }

    public int getDegreeB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.degreeB;
    }

    public Integer getDegreeC() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.degreeC;
    }

    public Integer getDegreeD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Integer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.degreeD;
    }

    public int getDegreeN() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.degreeN;
    }

    public int getDistance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.distance;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "SlideConfig{degreeA=" + this.degreeA + ", degreeB=" + this.degreeB + ", degreeC=" + this.degreeC + ", degreeD=" + this.degreeD + ", degreeN=" + this.degreeN + ", distance=" + this.distance + '}';
    }

    SlideConfig(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        setDegreeA(builder.degreeA);
        setDegreeB(builder.degreeB);
        setDegreeC(builder.degreeC);
        setDegreeD(builder.degreeD);
        setDegreeN(builder.degreeN);
        setDistance(builder.distance);
    }
}

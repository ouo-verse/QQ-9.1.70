package com.tencent.opentelemetry.api.baggage.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.baggage.BaggageBuilder;
import com.tencent.opentelemetry.api.baggage.c;

/* loaded from: classes22.dex */
public class Parser {
    static IPatchRedirector $redirector_;
    private final String baggageHeader;
    private final Element key;
    private String meta;
    private int metaStart;
    private boolean skipToNext;
    private State state;
    private final Element value;

    /* renamed from: com.tencent.opentelemetry.api.baggage.propagation.Parser$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15884);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State = iArr;
            try {
                iArr[State.VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State[State.META.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State[State.KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes22.dex */
    public static final class State {
        private static final /* synthetic */ State[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final State KEY;
        public static final State META;
        public static final State VALUE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15886);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            State state = new State("KEY", 0);
            KEY = state;
            State state2 = new State("VALUE", 1);
            VALUE = state2;
            State state3 = new State("META", 2);
            META = state3;
            $VALUES = new State[]{state, state2, state3};
        }

        State(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public Parser(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.key = Element.createKeyElement();
        this.value = Element.createValueElement();
        this.baggageHeader = str;
        reset(0);
    }

    private void reset(int i3) {
        this.skipToNext = false;
        this.state = State.KEY;
        this.key.reset(i3);
        this.value.reset(i3);
        this.meta = "";
        this.metaStart = 0;
    }

    private void setState(State state, int i3) {
        this.state = state;
        this.metaStart = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parseInto(BaggageBuilder baggageBuilder) {
        int length = this.baggageHeader.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = this.baggageHeader.charAt(i3);
            if (this.skipToNext) {
                if (charAt == ',') {
                    reset(i3 + 1);
                }
            } else if (charAt != ',') {
                if (charAt != ';') {
                    if (charAt != '=') {
                        int i16 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State[this.state.ordinal()];
                        if (i16 != 1) {
                            if (i16 == 3) {
                                this.skipToNext = !this.key.tryNextChar(charAt, i3);
                            }
                        } else {
                            this.skipToNext = !this.value.tryNextChar(charAt, i3);
                        }
                    } else if (this.state == State.KEY) {
                        if (this.key.tryTerminating(i3, this.baggageHeader)) {
                            setState(State.VALUE, i3 + 1);
                        } else {
                            this.skipToNext = true;
                        }
                    }
                } else if (this.state == State.VALUE) {
                    this.skipToNext = !this.value.tryTerminating(i3, this.baggageHeader);
                    setState(State.META, i3 + 1);
                }
            } else {
                int i17 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State[this.state.ordinal()];
                if (i17 != 1) {
                    if (i17 == 2) {
                        this.meta = this.baggageHeader.substring(this.metaStart, i3).trim();
                    }
                } else {
                    this.value.tryTerminating(i3, this.baggageHeader);
                }
                baggageBuilder.put(this.key.getValue(), this.value.getValue(), c.a(this.meta));
                reset(i3 + 1);
            }
        }
        int i18 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$baggage$propagation$Parser$State[this.state.ordinal()];
        if (i18 != 1) {
            if (i18 == 2) {
                baggageBuilder.put(this.key.getValue(), this.value.getValue(), c.a(this.baggageHeader.substring(this.metaStart).trim()));
                return;
            }
            return;
        }
        if (!this.skipToNext) {
            this.value.tryTerminating(this.baggageHeader.length(), this.baggageHeader);
            baggageBuilder.put(this.key.getValue(), this.value.getValue());
        }
    }
}

package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public interface Service {

    /* compiled from: P */
    @Beta
    /* loaded from: classes2.dex */
    public enum State {
        NEW { // from class: com.google.common.util.concurrent.Service.State.1
            @Override // com.google.common.util.concurrent.Service.State
            boolean isTerminal() {
                return false;
            }
        },
        STARTING { // from class: com.google.common.util.concurrent.Service.State.2
            @Override // com.google.common.util.concurrent.Service.State
            boolean isTerminal() {
                return false;
            }
        },
        RUNNING { // from class: com.google.common.util.concurrent.Service.State.3
            @Override // com.google.common.util.concurrent.Service.State
            boolean isTerminal() {
                return false;
            }
        },
        STOPPING { // from class: com.google.common.util.concurrent.Service.State.4
            @Override // com.google.common.util.concurrent.Service.State
            boolean isTerminal() {
                return false;
            }
        },
        TERMINATED { // from class: com.google.common.util.concurrent.Service.State.5
            @Override // com.google.common.util.concurrent.Service.State
            boolean isTerminal() {
                return true;
            }
        },
        FAILED { // from class: com.google.common.util.concurrent.Service.State.6
            @Override // com.google.common.util.concurrent.Service.State
            boolean isTerminal() {
                return true;
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean isTerminal();
    }

    State state();

    /* compiled from: P */
    @Beta
    /* loaded from: classes2.dex */
    public static abstract class b {
        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }

        public void a(State state, Throwable th5) {
        }
    }
}

package com.tencent.hippykotlin.demo.pages.base;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class RefreshListState {

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Empty extends RefreshListState {
        public Empty() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Error extends RefreshListState {
        public Error() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Idle extends RefreshListState {
        public static final Idle INSTANCE = new Idle();

        public Idle() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Loading extends RefreshListState {
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class LoadingMoreResult extends RefreshListState {
        public final boolean hasMoreData;
        public final boolean isSucceed;

        public LoadingMoreResult(boolean z16, boolean z17) {
            super(null);
            this.isSucceed = z16;
            this.hasMoreData = z17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class RefreshResult extends RefreshListState {
        public final boolean hasMoreData;
        public final boolean isSucceed;

        public RefreshResult(boolean z16, boolean z17) {
            super(null);
            this.isSucceed = z16;
            this.hasMoreData = z17;
        }
    }

    public /* synthetic */ RefreshListState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public RefreshListState() {
    }
}

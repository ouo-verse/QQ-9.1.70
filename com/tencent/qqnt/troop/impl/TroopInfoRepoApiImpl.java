package com.tencent.qqnt.troop.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.ab;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bE\u0010FJ!\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001Je\u0010\u0017\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u0010\u0018\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u0010\u0019\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Jm\u0010\u001b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u0010\u001c\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001J\u009b\u0001\u0010$\u001a\u00020\u00062\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001d2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2n\u0010\u0016\u001aj\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u001d\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0004\u0018\u0001`#H\u0096\u0001Je\u0010%\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Jm\u0010'\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u0010(\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001J\u0082\u0001\u0010.\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2S\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0006\u0018\u00010*j\u0004\u0018\u0001`-H\u0096\u0001Je\u0010/\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Jo\u00101\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00100\u001a\u00020\n2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u00102\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Jz\u00103\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2S\u0010\u0016\u001aO\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0006\u0018\u00010*j\u0004\u0018\u0001`-H\u0096\u0001Jm\u00105\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Jm\u00106\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u00107\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u00108\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001J\u008f\u0001\u0010:\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2h\u0010\u0016\u001ad\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0004\u0018\u0001`9H\u0096\u0001J\u008f\u0001\u0010;\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2h\u0010\u0016\u001ad\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0004\u0018\u0001`9H\u0096\u0001Je\u0010<\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001Je\u0010=\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001J]\u0010>\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2>\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fj\u0004\u0018\u0001`\u0015H\u0096\u0001J\u0015\u0010?\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010@\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u001b\u0010C\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010B\u001a\u00020AH\u0096\u0001J\u0013\u0010D\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010AH\u0096\u0001\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopInfoRepoApiImpl;", "Lcom/tencent/qqnt/troop/ITroopInfoRepoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "groupCodeList", "", "batchFetchTroopBasicInfo", "", "troopUin", "", "checkTroopHasAvatarFromMMKV", "from", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "callback", "fetchLowCreditTroopBasicInfo", "fetchTroopBasicInfo", "fetchTroopBasicInfoWithExt", "isFromMsg0x26", "fetchTroopClassType", "fetchTroopClassTypeForGuest", "", "troopUinList", "Lkotlin/Function4;", "", "errCode", "errMsg", "Lcom/tencent/qqnt/troop/FetchTroopPrivilegeListCallback;", "fetchTroopCreateTroopPrivilegeFlag", "fetchTroopCredit", "forceNet", "fetchTroopInfoExt", "fetchTroopInfoForAIO", "isMember", "Lkotlin/Function3;", "code", "info", "Lcom/tencent/qqnt/troop/FetchTroopDetailInfoCallback;", "fetchTroopInfoForBatch", "fetchTroopInfoForGameCard", "needPrivilege", "fetchTroopInfoForJoinTroop", "fetchTroopInfoForMaskChanged", "fetchTroopInfoForNoAuthMemberLimit", "isTroopMember", "fetchTroopJoinType", "fetchTroopMaxAdminNum", "fetchTroopMemberNumForJoin", "fetchTroopPayEnterStatus", "Lcom/tencent/qqnt/troop/FetchTroopPrivilegeCallback;", "fetchTroopPayPrivilege", "fetchTroopPhotoPrivilege", "fetchTroopSeqAndJoinTime", "fetchTroopSpeechLimitFreq", "fetchTroopTags", "getTroopInfoFromCache", "getTroopNameForPush", "Lcom/tencent/qqnt/troop/ab;", "observer", "registerTroopInfoChangedObserver", "unregisterTroopInfoChangedObserver", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopInfoRepoApiImpl implements ITroopInfoRepoApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopInfoRepo $$delegate_0;

    public TroopInfoRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopInfoRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void batchFetchTroopBasicInfo(@NotNull ArrayList<Long> groupCodeList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupCodeList);
        } else {
            Intrinsics.checkNotNullParameter(groupCodeList, "groupCodeList");
            this.$$delegate_0.batchFetchTroopBasicInfo(groupCodeList);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public boolean checkTroopHasAvatarFromMMKV(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin)).booleanValue();
        }
        return this.$$delegate_0.checkTroopHasAvatarFromMMKV(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchLowCreditTroopBasicInfo(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchLowCreditTroopBasicInfo(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopBasicInfo(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopBasicInfo(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopBasicInfoWithExt(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopBasicInfoWithExt(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopClassType(@Nullable String troopUin, boolean isFromMsg0x26, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, Boolean.valueOf(isFromMsg0x26), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopClassType(troopUin, isFromMsg0x26, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopClassTypeForGuest(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopClassTypeForGuest(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopCreateTroopPrivilegeFlag(@NotNull List<String> troopUinList, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function4<? super Boolean, ? super Integer, ? super String, ? super List<? extends TroopInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUinList, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUinList, "troopUinList");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.fetchTroopCreateTroopPrivilegeFlag(troopUinList, from, lifecycleOwner, callback);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopCredit(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopCredit(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoExt(@Nullable String troopUin, boolean forceNet, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, Boolean.valueOf(forceNet), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoExt(troopUin, forceNet, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForAIO(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoForAIO(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForBatch(@Nullable String troopUin, boolean isMember, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function3<? super Boolean, ? super Integer, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, Boolean.valueOf(isMember), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoForBatch(troopUin, isMember, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForGameCard(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoForGameCard(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForJoinTroop(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, boolean needPrivilege, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, from, lifecycleOwner, Boolean.valueOf(needPrivilege), callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoForJoinTroop(troopUin, from, lifecycleOwner, needPrivilege, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForMaskChanged(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoForMaskChanged(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForNoAuthMemberLimit(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function3<? super Boolean, ? super Integer, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopInfoForNoAuthMemberLimit(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopJoinType(@Nullable String troopUin, boolean isTroopMember, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, troopUin, Boolean.valueOf(isTroopMember), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopJoinType(troopUin, isTroopMember, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopMaxAdminNum(@Nullable String troopUin, boolean isTroopMember, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, troopUin, Boolean.valueOf(isTroopMember), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMaxAdminNum(troopUin, isTroopMember, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopMemberNumForJoin(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberNumForJoin(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopPayEnterStatus(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopPayEnterStatus(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopPayPrivilege(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function4<? super Boolean, ? super Integer, ? super String, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopPayPrivilege(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopPhotoPrivilege(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function4<? super Boolean, ? super Integer, ? super String, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopPhotoPrivilege(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopSeqAndJoinTime(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopSeqAndJoinTime(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopSpeechLimitFreq(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopSpeechLimitFreq(troopUin, from, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopTags(@Nullable String troopUin, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, troopUin, lifecycleOwner, callback);
        } else {
            this.$$delegate_0.fetchTroopTags(troopUin, lifecycleOwner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    @Nullable
    public TroopInfo getTroopInfoFromCache(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 27, (Object) this, (Object) troopUin);
        }
        return this.$$delegate_0.getTroopInfoFromCache(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    @NotNull
    public String getTroopNameForPush(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this, (Object) troopUin);
        }
        return this.$$delegate_0.getTroopNameForPush(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void registerTroopInfoChangedObserver(@Nullable LifecycleOwner lifecycleOwner, @NotNull ab observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) lifecycleOwner, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.$$delegate_0.registerTroopInfoChangedObserver(lifecycleOwner, observer);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void unregisterTroopInfoChangedObserver(@Nullable ab observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) observer);
        } else {
            this.$$delegate_0.unregisterTroopInfoChangedObserver(observer);
        }
    }
}

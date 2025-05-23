package com.tencent.mobileqq.flock.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/flock/api/FlockConstants$FlockListScene", "", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "<init>", "(Ljava/lang/String;I)V", "ACTIVITY", "RECOM", "TROOP", "PUBLISH", "JOIN", "TOPIC_AGGREGATION", "qq-flock-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockConstants$FlockListScene {
    private static final /* synthetic */ FlockConstants$FlockListScene[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final FlockConstants$FlockListScene ACTIVITY;
    public static final FlockConstants$FlockListScene JOIN;
    public static final FlockConstants$FlockListScene PUBLISH;
    public static final FlockConstants$FlockListScene RECOM;
    public static final FlockConstants$FlockListScene TOPIC_AGGREGATION;
    public static final FlockConstants$FlockListScene TROOP;

    private static final /* synthetic */ FlockConstants$FlockListScene[] $values() {
        return new FlockConstants$FlockListScene[]{ACTIVITY, RECOM, TROOP, PUBLISH, JOIN, TOPIC_AGGREGATION};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ACTIVITY = new FlockConstants$FlockListScene("ACTIVITY", 0);
        RECOM = new FlockConstants$FlockListScene("RECOM", 1);
        TROOP = new FlockConstants$FlockListScene("TROOP", 2);
        PUBLISH = new FlockConstants$FlockListScene("PUBLISH", 3);
        JOIN = new FlockConstants$FlockListScene("JOIN", 4);
        TOPIC_AGGREGATION = new FlockConstants$FlockListScene("TOPIC_AGGREGATION", 5);
        $VALUES = $values();
    }

    FlockConstants$FlockListScene(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static FlockConstants$FlockListScene valueOf(String str) {
        return (FlockConstants$FlockListScene) Enum.valueOf(FlockConstants$FlockListScene.class, str);
    }

    public static FlockConstants$FlockListScene[] values() {
        return (FlockConstants$FlockListScene[]) $VALUES.clone();
    }
}

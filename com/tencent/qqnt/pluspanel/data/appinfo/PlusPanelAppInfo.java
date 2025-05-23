package com.tencent.qqnt.pluspanel.data.appinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.qqnt.pluspanel.data.b;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b]\b&\u0018\u0000 q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001rB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\bp\u0010\u001eJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0011\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002J*\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u0016R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR$\u0010.\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R$\u00107\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010/\u001a\u0004\b8\u00101\"\u0004\b9\u00103R$\u0010:\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010/\u001a\u0004\b;\u00101\"\u0004\b<\u00103R$\u0010=\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010/\u001a\u0004\b>\u00101\"\u0004\b?\u00103R$\u0010@\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010/\u001a\u0004\bA\u00101\"\u0004\bB\u00103R$\u0010C\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010/\u001a\u0004\bD\u00101\"\u0004\bE\u00103R$\u0010F\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010/\u001a\u0004\bG\u00101\"\u0004\bH\u00103R$\u0010I\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R$\u0010L\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010/\u001a\u0004\bM\u00101\"\u0004\bN\u00103R$\u0010O\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010/\u001a\u0004\bP\u00101\"\u0004\bQ\u00103R$\u0010R\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010/\u001a\u0004\bS\u00101\"\u0004\bT\u00103R$\u0010U\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010/\u001a\u0004\bV\u00101\"\u0004\bW\u00103R$\u0010X\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010/\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R$\u0010[\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010/\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R\"\u0010^\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\"\u0010g\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010_\u001a\u0004\bg\u0010a\"\u0004\bh\u0010cR\"\u0010i\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010_\u001a\u0004\bi\u0010a\"\u0004\bj\u0010cR6\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006s"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "Ljava/io/Serializable;", "", "", "isTroop", "isC2C", "", "getAppName", "getTitle", "", "defaultDrawableID", "getAppID", "getManageConfigID", "state", "", "onChatPieLifeCycle", "getRedDotID", "other", "compareTo", "Lcom/tencent/qqnt/pluspanel/data/b;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "childList", "decorate", "uinType", "I", "getUinType", "()I", "setUinType", "(I)V", "appid", "getAppid", "setAppid", "enableC2C", "getEnableC2C", "setEnableC2C", "enableGroup", "getEnableGroup", "setEnableGroup", "sort", "getSort", "setSort", NotifyMsgApiImpl.KEY_GROUP_TYPE, "getGroupType", "setGroupType", "hashVal", "Ljava/lang/String;", "getHashVal", "()Ljava/lang/String;", "setHashVal", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "name", "getName", "setName", "enName", "getEnName", "setEnName", "iconVip", "getIconVip", "setIconVip", "iconUrl", "getIconUrl", "setIconUrl", "iconPress", "getIconPress", "setIconPress", "simpleDayUrl", "getSimpleDayUrl", "setSimpleDayUrl", "simpleDayPressUrl", "getSimpleDayPressUrl", "setSimpleDayPressUrl", "simpleNightUrl", "getSimpleNightUrl", "setSimpleNightUrl", "simpleNightPressUrl", "getSimpleNightPressUrl", "setSimpleNightPressUrl", "iconYouth", "getIconYouth", "setIconYouth", "actionType", "getActionType", "setActionType", "action", "getAction", "setAction", "minVersion", "getMinVersion", "setMinVersion", "redPoint", "Z", "getRedPoint", "()Z", "setRedPoint", "(Z)V", "canRemove", "getCanRemove", "setCanRemove", "isGray", "setGray", "isRobotAIO", "setRobotAIO", "Ljava/util/ArrayList;", "getChildList", "()Ljava/util/ArrayList;", "setChildList", "(Ljava/util/ArrayList;)V", "<init>", "Companion", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class PlusPanelAppInfo implements Serializable, Comparable<PlusPanelAppInfo> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "PlusPanelAppInfo";
    public static final long serialVersionUID = 1;

    @Nullable
    private String action;

    @Nullable
    private String actionType;
    private int appid;
    private boolean canRemove;

    @Nullable
    private ArrayList<PlusPanelAppInfo> childList;

    @Nullable
    private String enName;
    private int enableC2C;
    private int enableGroup;
    private int groupType;

    @Nullable
    private String hashVal;

    @Nullable
    private String iconPress;

    @Nullable
    private String iconUrl;

    @Nullable
    private String iconVip;

    @Nullable
    private String iconYouth;
    private boolean isGray;
    private boolean isRobotAIO;

    @Nullable
    private String minVersion;

    @Nullable
    private String name;
    private boolean redPoint;

    @Nullable
    private String simpleDayPressUrl;

    @Nullable
    private String simpleDayUrl;

    @Nullable
    private String simpleNightPressUrl;

    @Nullable
    private String simpleNightUrl;
    private int sort;
    private int uinType;

    @Nullable
    private String url;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo$a;", "", "", "TAG", "Ljava/lang/String;", "", "serialVersionUID", "J", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 62)) {
            redirector.redirect((short) 62);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlusPanelAppInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.appid = 0;
        this.enableC2C = 0;
        this.enableGroup = 0;
        this.sort = 0;
        this.groupType = 0;
        this.uinType = 0;
        this.name = "";
        this.enName = "";
        this.url = "";
        this.iconUrl = "";
        this.iconPress = "";
        this.simpleDayUrl = "";
        this.simpleDayPressUrl = "";
        this.simpleNightUrl = "";
        this.simpleNightPressUrl = "";
        this.iconYouth = "";
        this.actionType = "";
        this.action = "";
        this.hashVal = "";
        this.minVersion = "";
        this.isGray = false;
        this.canRemove = false;
        this.childList = null;
    }

    public final void decorate(@NotNull b data, @Nullable ArrayList<PlusPanelAppInfo> childList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) data, (Object) childList);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!TextUtils.isEmpty(data.i())) {
            this.url = data.i();
        }
        if (!TextUtils.isEmpty(data.e())) {
            this.name = data.e();
        }
        if (!TextUtils.isEmpty(data.c())) {
            this.enName = data.c();
        }
        if (!TextUtils.isEmpty(data.d())) {
            this.iconUrl = data.d();
        }
        if (!TextUtils.isEmpty(data.g())) {
            this.simpleDayUrl = data.g();
        }
        if (!TextUtils.isEmpty(data.h())) {
            this.simpleNightUrl = data.h();
        }
        if (!TextUtils.isEmpty(data.b())) {
            this.actionType = data.b();
        }
        if (!TextUtils.isEmpty(data.a())) {
            this.action = data.a();
        }
        if (!TextUtils.isEmpty(data.j())) {
            this.iconVip = data.j();
        }
        this.redPoint = data.f();
        this.isRobotAIO = data.k();
        this.childList = childList;
    }

    public abstract int defaultDrawableID();

    @Nullable
    public final String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.action;
    }

    @Nullable
    public final String getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.actionType;
    }

    public abstract int getAppID();

    @Nullable
    public final String getAppName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (String) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        if (!TextUtils.isEmpty(this.name)) {
            return this.name;
        }
        return getTitle();
    }

    public final int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.appid;
    }

    public final boolean getCanRemove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.canRemove;
    }

    @Nullable
    public final ArrayList<PlusPanelAppInfo> getChildList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (ArrayList) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return this.childList;
    }

    @Nullable
    public final String getEnName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.enName;
    }

    public final int getEnableC2C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.enableC2C;
    }

    public final int getEnableGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.enableGroup;
    }

    public final int getGroupType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.groupType;
    }

    @Nullable
    public final String getHashVal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.hashVal;
    }

    @Nullable
    public final String getIconPress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.iconPress;
    }

    @Nullable
    public final String getIconUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.iconUrl;
    }

    @Nullable
    public final String getIconVip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.iconVip;
    }

    @Nullable
    public final String getIconYouth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.iconYouth;
    }

    public int getManageConfigID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Integer) iPatchRedirector.redirect((short) 57, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final String getMinVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.minVersion;
    }

    @Nullable
    public final String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.name;
    }

    public int getRedDotID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean getRedPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.redPoint;
    }

    @Nullable
    public final String getSimpleDayPressUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.simpleDayPressUrl;
    }

    @Nullable
    public final String getSimpleDayUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.simpleDayUrl;
    }

    @Nullable
    public final String getSimpleNightPressUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.simpleNightPressUrl;
    }

    @Nullable
    public final String getSimpleNightUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.simpleNightUrl;
    }

    public final int getSort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.sort;
    }

    @Nullable
    public abstract String getTitle();

    public final int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.uinType;
    }

    @Nullable
    public final String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.url;
    }

    public final boolean isC2C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        int i3 = this.uinType;
        if (i3 == 1 || i3 == 102) {
            return true;
        }
        return false;
    }

    public final boolean isGray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return this.isGray;
    }

    public final boolean isRobotAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.isRobotAIO;
    }

    public final boolean isTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        if (this.uinType == 2) {
            return true;
        }
        return false;
    }

    protected void onChatPieLifeCycle(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, state);
        }
    }

    public final void setAction(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        } else {
            this.action = str;
        }
    }

    public final void setActionType(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
        } else {
            this.actionType = str;
        }
    }

    public final void setAppid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.appid = i3;
        }
    }

    public final void setCanRemove(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.canRemove = z16;
        }
    }

    public final void setChildList(@Nullable ArrayList<PlusPanelAppInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) arrayList);
        } else {
            this.childList = arrayList;
        }
    }

    public final void setEnName(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.enName = str;
        }
    }

    public final void setEnableC2C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.enableC2C = i3;
        }
    }

    public final void setEnableGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.enableGroup = i3;
        }
    }

    public final void setGray(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.isGray = z16;
        }
    }

    public final void setGroupType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.groupType = i3;
        }
    }

    public final void setHashVal(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.hashVal = str;
        }
    }

    public final void setIconPress(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.iconPress = str;
        }
    }

    public final void setIconUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.iconUrl = str;
        }
    }

    public final void setIconVip(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.iconVip = str;
        }
    }

    public final void setIconYouth(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        } else {
            this.iconYouth = str;
        }
    }

    public final void setMinVersion(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
        } else {
            this.minVersion = str;
        }
    }

    public final void setName(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.name = str;
        }
    }

    public final void setRedPoint(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        } else {
            this.redPoint = z16;
        }
    }

    public final void setRobotAIO(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
        } else {
            this.isRobotAIO = z16;
        }
    }

    public final void setSimpleDayPressUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.simpleDayPressUrl = str;
        }
    }

    public final void setSimpleDayUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.simpleDayUrl = str;
        }
    }

    public final void setSimpleNightPressUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
        } else {
            this.simpleNightPressUrl = str;
        }
    }

    public final void setSimpleNightUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            this.simpleNightUrl = str;
        }
    }

    public final void setSort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.sort = i3;
        }
    }

    public final void setUinType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.uinType = i3;
        }
    }

    public final void setUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.url = str;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull PlusPanelAppInfo other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this, (Object) other)).intValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        return this.sort - other.sort;
    }
}

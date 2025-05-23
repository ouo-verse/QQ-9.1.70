package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.troop.flock.QeventPB$Feed;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/f;", "", "targetId", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "", "b", "toString", "c", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "()Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "dataType", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "d", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "f", "()Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "i", "(Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;)V", "troopItem", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "e", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "()Lcom/tencent/mobileqq/data/MayKnowRecommend;", tl.h.F, "(Lcom/tencent/mobileqq/data/MayKnowRecommend;)V", "recommendPerson", "Ltencent/im/troop/flock/QeventPB$Feed;", "Ltencent/im/troop/flock/QeventPB$Feed;", "()Ltencent/im/troop/flock/QeventPB$Feed;", "g", "(Ltencent/im/troop/flock/QeventPB$Feed;)V", "flockData", "<init>", "(Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AddContactDataType dataType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecommendTroopItem troopItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MayKnowRecommend recommendPerson;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QeventPB$Feed flockData;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180870a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49781);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180870a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull AddContactDataType dataType) {
        super(3, null);
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataType);
        } else {
            this.dataType = dataType;
        }
    }

    public final boolean b(@NotNull String targetId, @NotNull AddContactDataType type) {
        String str;
        String str2;
        String str3;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) targetId, (Object) type)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.dataType != type) {
            return false;
        }
        int i3 = a.f180870a[type.ordinal()];
        String str4 = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        QeventPB$Feed qeventPB$Feed = this.flockData;
                        if (qeventPB$Feed != null && (pBStringField = qeventPB$Feed.f436058id) != null) {
                            str4 = pBStringField.get();
                        }
                        return Intrinsics.areEqual(str4, targetId);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                MayKnowRecommend mayKnowRecommend = this.recommendPerson;
                if (mayKnowRecommend != null && (str3 = mayKnowRecommend.uin) != null) {
                    str4 = str3;
                }
                return Intrinsics.areEqual(str4, targetId);
            }
            RecommendTroopItem recommendTroopItem = this.troopItem;
            if (recommendTroopItem != null && (str2 = recommendTroopItem.uin) != null) {
                str4 = str2;
            }
            return Intrinsics.areEqual(str4, targetId);
        }
        RecommendTroopItem recommendTroopItem2 = this.troopItem;
        if (recommendTroopItem2 != null && (str = recommendTroopItem2.uin) != null) {
            str4 = str;
        }
        return Intrinsics.areEqual(str4, targetId);
    }

    @NotNull
    public final AddContactDataType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AddContactDataType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataType;
    }

    @Nullable
    public final QeventPB$Feed d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QeventPB$Feed) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.flockData;
    }

    @Nullable
    public final MayKnowRecommend e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MayKnowRecommend) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.recommendPerson;
    }

    @Nullable
    public final RecommendTroopItem f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecommendTroopItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopItem;
    }

    public final void g(@Nullable QeventPB$Feed qeventPB$Feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qeventPB$Feed);
        } else {
            this.flockData = qeventPB$Feed;
        }
    }

    public final void h(@Nullable MayKnowRecommend mayKnowRecommend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) mayKnowRecommend);
        } else {
            this.recommendPerson = mayKnowRecommend;
        }
    }

    public final void i(@Nullable RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) recommendTroopItem);
        } else {
            this.troopItem = recommendTroopItem;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "AddContactDataItem(dataType=" + this.dataType + ", troopItem=" + this.troopItem + ", recommendPerson=" + this.recommendPerson + ", flockData=" + this.flockData + ")";
    }
}

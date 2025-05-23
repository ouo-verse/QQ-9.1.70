package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/forward/ForwardWalletPetArkMsgOption;", "Lcom/tencent/mobileqq/forward/ForwardArkMsgOption;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "o", "", AppConstants.Key.SHARE_REQ_QQ_TYPE, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "r", "t", "p", "", "buildForwardAbility", "getForwardRecentList", "filterRecentForwardList", "isSupportMultipleForward", "Landroid/content/Intent;", "i", "<init>", "(Landroid/content/Intent;)V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ForwardWalletPetArkMsgOption extends ForwardArkMsgOption {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/forward/ForwardWalletPetArkMsgOption$a;", "", "", "b", "FLAG_SHARE_TYPE_DISCUSS", "I", "FLAG_SHARE_TYPE_FRIEND", "FLAG_SHARE_TYPE_TROOP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.forward.ForwardWalletPetArkMsgOption$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            return 13;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57774);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ForwardWalletPetArkMsgOption(@Nullable Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    private final ArrayList<RecentUser> o(List<RecentUser> list) {
        ArrayList<RecentUser> arrayList = new ArrayList<>();
        if (list != null) {
            int p16 = p();
            for (RecentUser recentUser : list) {
                if (recentUser.getType() == 0 && s(p16)) {
                    arrayList.add(recentUser);
                } else if (recentUser.getType() == 1 && t(p16)) {
                    arrayList.add(recentUser);
                } else if (recentUser.getType() == 3000 && r(p16)) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    private final int p() {
        return this.mIntent.getIntExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, INSTANCE.b());
    }

    private final boolean q(int shareQQType) {
        if (shareQQType == 1) {
            return true;
        }
        return false;
    }

    private final boolean r(int shareQQType) {
        if ((shareQQType & 8) != 0) {
            return true;
        }
        return false;
    }

    private final boolean s(int shareQQType) {
        if ((shareQQType & 1) != 0) {
            return true;
        }
        return false;
    }

    private final boolean t(int shareQQType) {
        if ((shareQQType & 4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int p16 = p();
        if (s(p16) && allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (t(p16) && allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (r(p16) && allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (q(p16)) {
            this.mForwardAbilities.add(e.Y3);
        }
        QLog.i("ForwardWalletPetArkMsg", 1, "[buildForwardAbility] shareQQType:" + p16);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void filterRecentForwardList(@Nullable List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else if (list != null) {
            ArrayList<RecentUser> o16 = o(list);
            list.clear();
            list.addAll(o16);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    @NotNull
    public List<RecentUser> getForwardRecentList(@Nullable List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        return o(list);
    }

    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return !q(p());
    }
}

package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/b;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "", "", "w", "", "count", "", "y", "detail", "Lkotlin/Function0;", "callback", HippyTKDListViewAdapter.X, "", DomainData.DOMAIN_NAME, "Z", "isTeacher", "o", "Ljava/lang/Integer;", "unClockInCount", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "troopUin", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends HWDetailMediaDataModel<GroupSchoolTaskData> {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isTeacher;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer unClockInCount;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupSchoolTaskData detail;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/b$a", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "selfInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements com.tencent.qqnt.troopmemberlist.g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo selfInfo) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) selfInfo);
                return;
            }
            b bVar = b.this;
            boolean z18 = true;
            if (selfInfo != null && selfInfo.getHWIdentity() == 332) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (selfInfo != null && selfInfo.getHWIdentity() == 333) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z18 = false;
                }
            }
            bVar.isTeacher = z18;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/b$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull CoroutineScope scope, @NotNull String troopUin) {
        super(scope, troopUin);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) troopUin);
            return;
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            TroopMemberListRepo.INSTANCE.fetchTroopMemberInfoWithExtInfo(troopUin, e16.getCurrentAccountUin(), false, null, "HWClockInDetailMediaDataModel", new a());
        }
    }

    private final List<String> w() {
        String str;
        List<String> emptyList;
        GroupSchoolTaskData groupSchoolTaskData = this.detail;
        if (groupSchoolTaskData == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = groupSchoolTaskData.status;
        if (i3 == 1) {
            int i16 = groupSchoolTaskData.timeSettings.cycle;
            arrayList.add("\u5df2\u8fdb\u884c" + groupSchoolTaskData.progress + "/" + i16 + "\u5929");
        } else if (i3 == 3) {
            arrayList.add("\u6253\u5361\u5df2\u7ed3\u675f");
        }
        if (this.isTeacher) {
            if (groupSchoolTaskData.allowMakeUp) {
                str = "\u5141\u8bb8\u8865\u5361";
            } else {
                str = "\u4e0d\u5141\u8bb8\u8865\u5361";
            }
            arrayList.add(str);
        } else {
            Integer num = this.unClockInCount;
            if (num != null) {
                arrayList.add("\u7f3a\u5361" + num + "\u5929");
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void t(@NotNull GroupSchoolTaskData detail, @Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) detail, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.detail = detail;
        p().setTags(w());
        TitleItem p16 = p();
        String str = detail.content.title;
        Intrinsics.checkNotNullExpressionValue(str, "detail.content.title");
        p16.setTitle(str);
        u(detail.authorUin, detail.publishTime, callback);
        GroupSchoolNoticeContent groupSchoolNoticeContent = detail.content;
        Intrinsics.checkNotNullExpressionValue(groupSchoolNoticeContent, "detail.content");
        s(groupSchoolNoticeContent);
    }

    public final void y(int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, count);
        } else {
            this.unClockInCount = Integer.valueOf(count);
            p().setTags(w());
        }
    }
}

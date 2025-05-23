package com.tencent.mobileqq.activity.contact.addcontact.gridentrance;

import android.content.Context;
import android.view.View;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactRemoteConfig;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.gridpage.QQGridContainerView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\u000b\u001a\u00020\n*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J$\u0010\u0014\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/c;", "", "Lcom/tencent/mobileqq/widget/gridpage/QQGridContainerView;", "", "", "entranceList", "Lkotlin/Function1;", "Landroid/view/View;", "", "onItemClick", "", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "b", "", "id", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "d", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f181154a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/gridentrance/c$a", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/i;", "Landroid/view/View;", "itemView", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<View, Unit> f181155a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super View, Unit> function1) {
            this.f181155a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.gridentrance.i
        public void a(@NotNull View itemView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemView);
            } else {
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f181155a.invoke(itemView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f181154a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@NotNull QQGridContainerView qQGridContainerView, @Nullable List<String> list, @NotNull Function1<? super View, Unit> onItemClick) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(qQGridContainerView, "<this>");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AddContactFunctionPanelHelper", 1, "create config grid view failure, entrance list is empty");
            return false;
        }
        if (!SimpleUIUtil.isNowElderMode() && FontSettingManager.getFontLevel() < 18.0f) {
            i3 = 4;
        } else {
            i3 = 3;
        }
        if (list.size() > i3) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        f fVar = new f(i16, i3);
        fVar.m(list);
        fVar.l(new a(onItemClick));
        qQGridContainerView.setAdapter(fVar);
        qQGridContainerView.setVisibility(0);
        return true;
    }

    @JvmStatic
    @NotNull
    public static final List<String> b(@NotNull Context context, @NotNull QQAppInterface app) {
        List<String> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        List<String> c16 = f181154a.c();
        int size = c16.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(c16.get(i3));
        }
        QLog.i("AddContactFunctionPanelHelper", 2, "AddContactsViewConfig fetches successfully\uff0ccontent=" + arrayList);
        if (BaseApplication.getContext().getSharedPreferences(app.getCurrentAccountUin(), 0).getInt("invitation_friend_entry", 0) != 1) {
            e(f181154a, arrayList, "8", null, 2, null);
        }
        if (PadUtil.a(context) == DeviceType.TABLET) {
            e(f181154a, arrayList, "4", null, 2, null);
        }
        if (!((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).showAddContactsMatchFriendEntry(app)) {
            e(f181154a, arrayList, "7", null, 2, null);
        }
        if (!((IAddContactRemoteConfig) QRoute.api(IAddContactRemoteConfig.class)).showFlockEntrance()) {
            e(f181154a, arrayList, "10", null, 2, null);
        }
        if (StudyModeManager.t()) {
            c cVar = f181154a;
            cVar.d(arrayList, "4", "study mode");
            cVar.d(arrayList, "2", "study mode");
            cVar.d(arrayList, "9", "study mode");
            cVar.d(arrayList, "10", "study mode");
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final List<String> c() {
        String f16 = com.tencent.mobileqq.troop.config.b.f294691a.f("101079", "entrance_list", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(f16);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(String.valueOf(jSONArray.getInt(i3)));
            }
        } catch (JSONException unused) {
            QLog.e("AddContactFunctionPanelHelper", 1, "invalid remote data: " + f16);
        }
        if (arrayList.isEmpty()) {
            return h.f181167a.b();
        }
        return arrayList;
    }

    private final void d(List<String> list, String str, String str2) {
        list.remove(str);
        QLog.i("AddContactFunctionPanelHelper", 2, "hide entry id: " + str + ", cause: " + str2);
    }

    static /* synthetic */ void e(c cVar, List list, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        cVar.d(list, str, str2);
    }
}

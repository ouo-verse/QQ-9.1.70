package com.tencent.mobileqq.troop.homework.clockin.list.data;

import com.qzone.homepage.business.model.FunnySpaceModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.clockin.b;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskPublishGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u00c6\u0001J\t\u0010\"\u001a\u00020\u0004H\u00d6\u0001J\t\u0010#\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010-\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010-\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010-\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010-\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b<\u0010/\"\u0004\b=\u00101\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/data/a;", "", "", "checkInWeekdays", "", h.F, "", "authorUin", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskPublishGroupInfo;", "Lkotlin/collections/ArrayList;", "list", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "publishTime", FunnySpaceModel.META_KEY_CYCLE, "f", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "taskData", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "rsp", "troopNameListStr", "o", "clockId", "title", "content", "daysInfoStr", "frequencyStr", "troopNameList", "a", "toString", "hashCode", "other", "", "equals", "J", "getAuthorUin", "()J", "setAuthorUin", "(J)V", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setClockId", "(Ljava/lang/String;)V", "k", "setTitle", "d", "setContent", "e", "setDaysInfoStr", "g", "setFrequencyStr", "i", "setPublishTime", "l", "setTroopNameList", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long authorUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String clockId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String content;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String daysInfoStr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String frequencyStr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String publishTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopNameList;

    public a() {
        this(0L, null, null, null, null, null, null, null, 255, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            return;
        }
        iPatchRedirector.redirect((short) 33, (Object) this);
    }

    public static /* synthetic */ a b(a aVar, long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
        long j16;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        if ((i3 & 1) != 0) {
            j16 = aVar.authorUin;
        } else {
            j16 = j3;
        }
        if ((i3 & 2) != 0) {
            str8 = aVar.clockId;
        } else {
            str8 = str;
        }
        if ((i3 & 4) != 0) {
            str9 = aVar.title;
        } else {
            str9 = str2;
        }
        if ((i3 & 8) != 0) {
            str10 = aVar.content;
        } else {
            str10 = str3;
        }
        if ((i3 & 16) != 0) {
            str11 = aVar.daysInfoStr;
        } else {
            str11 = str4;
        }
        if ((i3 & 32) != 0) {
            str12 = aVar.frequencyStr;
        } else {
            str12 = str5;
        }
        if ((i3 & 64) != 0) {
            str13 = aVar.publishTime;
        } else {
            str13 = str6;
        }
        if ((i3 & 128) != 0) {
            str14 = aVar.troopNameList;
        } else {
            str14 = str7;
        }
        return aVar.a(j16, str8, str9, str10, str11, str12, str13, str14);
    }

    private final String f(long publishTime, int cycle) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(publishTime * 1000);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        int abs = ((int) (Math.abs(calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000)) + 1;
        if (abs > cycle) {
            return "\u7b2c" + cycle + "/" + cycle + "\u5929\uff0c\u5df2\u7ed3\u675f";
        }
        return "\u7b2c" + abs + "/" + cycle + "\u5929";
    }

    private final String h(int checkInWeekdays) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            if (((1 << i16) & checkInWeekdays) != 0) {
                arrayList.add(Integer.valueOf(i16));
            }
        }
        if (arrayList.size() == 7) {
            return "\u6bcf\u5929";
        }
        Iterator it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            int i17 = i3 + 1;
            str = str + b.f296279a.a()[((Number) it.next()).intValue()];
            if (i3 != arrayList.size() - 1) {
                str = str + "\u3001";
            }
            i3 = i17;
        }
        return str;
    }

    private final String j(long publishTime) {
        String format = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH:mm", Locale.CHINA).format(new Date(publishTime * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(Date(publishTime * 1000))");
        return format;
    }

    private final String m(long authorUin, ArrayList<GroupSchoolTaskPublishGroupInfo> list) {
        String str = "";
        if (MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin() != authorUin) {
            return "";
        }
        Iterator<GroupSchoolTaskPublishGroupInfo> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            str = str + it.next().groupName;
            if (i3 != list.size() - 1) {
                str = str + "\u3001";
            }
            i3 = i16;
        }
        return str;
    }

    @NotNull
    public final a a(long authorUin, @NotNull String clockId, @NotNull String title, @NotNull String content, @NotNull String daysInfoStr, @NotNull String frequencyStr, @NotNull String publishTime, @NotNull String troopNameList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (a) iPatchRedirector.redirect((short) 29, this, Long.valueOf(authorUin), clockId, title, content, daysInfoStr, frequencyStr, publishTime, troopNameList);
        }
        Intrinsics.checkNotNullParameter(clockId, "clockId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(daysInfoStr, "daysInfoStr");
        Intrinsics.checkNotNullParameter(frequencyStr, "frequencyStr");
        Intrinsics.checkNotNullParameter(publishTime, "publishTime");
        Intrinsics.checkNotNullParameter(troopNameList, "troopNameList");
        return new a(authorUin, clockId, title, content, daysInfoStr, frequencyStr, publishTime, troopNameList);
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.clockId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.content;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.daysInfoStr;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.authorUin == aVar.authorUin && Intrinsics.areEqual(this.clockId, aVar.clockId) && Intrinsics.areEqual(this.title, aVar.title) && Intrinsics.areEqual(this.content, aVar.content) && Intrinsics.areEqual(this.daysInfoStr, aVar.daysInfoStr) && Intrinsics.areEqual(this.frequencyStr, aVar.frequencyStr) && Intrinsics.areEqual(this.publishTime, aVar.publishTime) && Intrinsics.areEqual(this.troopNameList, aVar.troopNameList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.frequencyStr;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return (((((((((((((androidx.fragment.app.a.a(this.authorUin) * 31) + this.clockId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.daysInfoStr.hashCode()) * 31) + this.frequencyStr.hashCode()) * 31) + this.publishTime.hashCode()) * 31) + this.troopNameList.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.publishTime;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.title;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.troopNameList;
    }

    public final void n(@NotNull GroupSchoolTaskData taskData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) taskData);
            return;
        }
        Intrinsics.checkNotNullParameter(taskData, "taskData");
        this.authorUin = taskData.authorUin;
        String str = taskData.taskId;
        Intrinsics.checkNotNullExpressionValue(str, "taskData.taskId");
        this.clockId = str;
        String str2 = taskData.content.title;
        Intrinsics.checkNotNullExpressionValue(str2, "taskData.content.title");
        this.title = str2;
        String str3 = taskData.content.content;
        Intrinsics.checkNotNullExpressionValue(str3, "taskData.content.content");
        this.content = str3;
        this.daysInfoStr = f(taskData.publishTime, taskData.timeSettings.cycle);
        this.frequencyStr = h(taskData.timeSettings.checkinWeekdays);
        this.publishTime = j(taskData.publishTime);
        long j3 = taskData.authorUin;
        ArrayList<GroupSchoolTaskPublishGroupInfo> arrayList = taskData.groups;
        Intrinsics.checkNotNullExpressionValue(arrayList, "taskData.groups");
        this.troopNameList = m(j3, arrayList);
    }

    public final void o(@NotNull PublishGroupSchoolTaskReq req, @NotNull PublishGroupSchoolTaskRsp rsp, @NotNull String troopNameListStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, req, rsp, troopNameListStr);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(troopNameListStr, "troopNameListStr");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        this.authorUin = Long.parseLong(currentUin);
        String str = rsp.tasks.get(0).taskId;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.tasks[0].taskId");
        this.clockId = str;
        String str2 = req.content.title;
        Intrinsics.checkNotNullExpressionValue(str2, "req.content.title");
        this.title = str2;
        String str3 = req.content.content;
        Intrinsics.checkNotNullExpressionValue(str3, "req.content.content");
        this.content = str3;
        this.daysInfoStr = f(currentTimeMillis, req.timeSettings.cycle);
        this.frequencyStr = h(req.timeSettings.checkinWeekdays);
        this.publishTime = j(currentTimeMillis);
        this.troopNameList = troopNameListStr;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "HWClockInData(authorUin=" + this.authorUin + ", clockId=" + this.clockId + ", title=" + this.title + ", content=" + this.content + ", daysInfoStr=" + this.daysInfoStr + ", frequencyStr=" + this.frequencyStr + ", publishTime=" + this.publishTime + ", troopNameList=" + this.troopNameList + ")";
    }

    public a(long j3, @NotNull String clockId, @NotNull String title, @NotNull String content, @NotNull String daysInfoStr, @NotNull String frequencyStr, @NotNull String publishTime, @NotNull String troopNameList) {
        Intrinsics.checkNotNullParameter(clockId, "clockId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(daysInfoStr, "daysInfoStr");
        Intrinsics.checkNotNullParameter(frequencyStr, "frequencyStr");
        Intrinsics.checkNotNullParameter(publishTime, "publishTime");
        Intrinsics.checkNotNullParameter(troopNameList, "troopNameList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), clockId, title, content, daysInfoStr, frequencyStr, publishTime, troopNameList);
            return;
        }
        this.authorUin = j3;
        this.clockId = clockId;
        this.title = title;
        this.content = content;
        this.daysInfoStr = daysInfoStr;
        this.frequencyStr = frequencyStr;
        this.publishTime = publishTime;
        this.troopNameList = troopNameList;
    }

    public /* synthetic */ a(long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? "" : str7);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

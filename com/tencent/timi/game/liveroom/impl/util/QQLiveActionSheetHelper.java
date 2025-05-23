package com.tencent.timi.game.liveroom.impl.util;

import android.content.Context;
import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.util.QQLiveActionSheetHelper;
import com.tencent.timi.game.sso.request.QQLiveO3ReportRequest;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mk4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/util/QQLiveActionSheetHelper;", "", "a", "Companion", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveActionSheetHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002JL\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J=\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u0017\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\fR\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/util/QQLiveActionSheetHelper$Companion;", "", "Landroid/content/Context;", "context", "", "reporteeUid", "", "beReportNick", "reporterUid", RemoteMessageConst.MessageBody.MSG_CONTENT, "", "f", "", "type", "", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "list", "c", "d", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "reportUid", "content", "reason", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/util/QQLiveActionSheetHelper$Companion$a", "Lmk4/b$a;", "", "type", "Lcom/tencent/mobileqq/qqlive/data/room/AdminReason;", "reason", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f378964a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f378965b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f378966c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f378967d;

            a(String str, long j3, String str2, long j16) {
                this.f378964a = str;
                this.f378965b = j3;
                this.f378966c = str2;
                this.f378967d = j16;
            }

            @Override // mk4.b.a
            public void a(int type, @Nullable AdminReason reason) {
                String str;
                int i3;
                QLog.d("Audience|ActionSheetHelper", 1, "onItemClick... reason:" + reason);
                if (type == ni4.b.f420212a.a() && (str = this.f378964a) != null) {
                    long j3 = this.f378965b;
                    String str2 = this.f378966c;
                    long j16 = this.f378967d;
                    Companion companion = QQLiveActionSheetHelper.INSTANCE;
                    if (reason != null) {
                        i3 = reason.f271215id;
                    } else {
                        i3 = 0;
                    }
                    companion.b(j3, str2, j16, str, i3);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(int type, List<? extends AdminReason> list, Context context, long reporteeUid, String beReportNick, long reporterUid, String msgContent) {
            if (list != null && !list.isEmpty()) {
                mk4.b bVar = new mk4.b(type, list, context, null);
                bVar.l0(new a(msgContent, reporterUid, beReportNick, reporteeUid));
                bVar.show();
            } else {
                QLog.e("Audience|ActionSheetHelper", 1, "forbiddenSpeech error " + list);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Context context, Long l3, String str, Long l16, String str2, ActionSheet jubaoActionSheet, View view, int i3, String str3) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(jubaoActionSheet, "$jubaoActionSheet");
            if (Intrinsics.areEqual(str3, "\u4e3e\u62a5")) {
                QQLiveActionSheetHelper.INSTANCE.f(context, l3.longValue(), str, l16.longValue(), str2);
            }
            jubaoActionSheet.dismiss();
        }

        private final void f(Context context, long reporteeUid, String beReportNick, long reporterUid, String msgContent) {
            ArrayList arrayList = new ArrayList();
            ArrayList<Pair> arrayList2 = new ArrayList();
            arrayList2.add(new Pair(1, context.getResources().getString(R.string.f199824qg)));
            arrayList2.add(new Pair(2, context.getResources().getString(R.string.f199784qc)));
            arrayList2.add(new Pair(3, context.getResources().getString(R.string.f199814qf)));
            arrayList2.add(new Pair(4, context.getResources().getString(R.string.f199794qd)));
            arrayList2.add(new Pair(5, context.getResources().getString(R.string.f199774qb)));
            arrayList2.add(new Pair(6, context.getResources().getString(R.string.f199804qe)));
            for (Pair pair : arrayList2) {
                arrayList.add(new AdminReason(((Number) pair.getFirst()).intValue(), (String) pair.getSecond()));
            }
            c(ni4.b.f420212a.a(), arrayList, context, reporteeUid, beReportNick, reporterUid, msgContent);
        }

        public final void b(long reporterUid, @Nullable final String beReportNick, long reportUid, @NotNull String content, int reason) {
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.i("Audience|ActionSheetHelper", 1, "[doReport] using o3, for " + beReportNick);
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveO3ReportRequest(reporterUid, reportUid, content, reason), new Function1<QQLiveResponse<lr4.b>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.util.QQLiveActionSheetHelper$Companion$doReportO3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<lr4.b> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<lr4.b> response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isFailed()) {
                        QLog.i("Audience|ActionSheetHelper", 1, "[doReport] onSuccess");
                        f.c("\u5df2\u6210\u529f\u5c06" + beReportNick + "\u4e3e\u62a5");
                        return;
                    }
                    QLog.i("Audience|ActionSheetHelper", 1, "[doReport] error, " + response);
                    f.c("\u4e3e\u62a5\u5931\u8d25");
                }
            });
        }

        public final void d(@NotNull final Context context, @Nullable final Long reporteeUid, @Nullable final String beReportNick, @Nullable final Long reporterUid, @Nullable final String msgContent) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (reporteeUid != null && reporterUid != null && reporteeUid.longValue() != 0) {
                final ActionSheet create = ActionSheet.create(context, -1, null, false);
                Intrinsics.checkNotNullExpressionValue(create, "create(\n                \u2026null, false\n            )");
                create.setMainTitle("\u56e0\u4e3b\u64ad\u8bbe\u7f6e\uff0c\u6682\u4e0d\u652f\u6301\u67e5\u770b\u4e2a\u4eba\u4fe1\u606f");
                create.addButton("\u4e3e\u62a5", 0);
                create.addCancelButton("\u53d6\u6d88");
                create.show();
                create.setOnButtonClickListenerV2(new ActionSheet.OnButtonClickListenerV2() { // from class: com.tencent.timi.game.liveroom.impl.util.a
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
                    public final void OnClick(View view, int i3, String str) {
                        QQLiveActionSheetHelper.Companion.e(context, reporteeUid, beReportNick, reporterUid, msgContent, create, view, i3, str);
                    }
                });
                return;
            }
            QLog.e("Audience|ActionSheetHelper", 1, "reporteeUid:" + reporteeUid + " reporterUid:" + reporterUid);
        }

        Companion() {
        }
    }
}

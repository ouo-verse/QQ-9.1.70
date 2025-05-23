package com.tencent.mobileqq.groupvideo.debug;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.groupvideo.debug.GroupVideoVersionListFragment$createVersionGroups$1;
import com.tencent.mobileqq.groupvideo.debug.a;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GroupVideoVersionListFragment$createVersionGroups$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Pair<String, String> $item;
    final /* synthetic */ List<Pair<String, String>> $list;
    final /* synthetic */ Pair<String, String> $obj;
    final /* synthetic */ GroupVideoVersionListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupVideoVersionListFragment$createVersionGroups$1(GroupVideoVersionListFragment groupVideoVersionListFragment, List<Pair<String, String>> list, Pair<String, String> pair, Pair<String, String> pair2) {
        super(0);
        this.this$0 = groupVideoVersionListFragment;
        this.$list = list;
        this.$item = pair;
        this.$obj = pair2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, groupVideoVersionListFragment, list, pair, pair2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GroupVideoVersionListFragment this$0, List list, Pair item, Pair obj) {
        ArrayList arrayList;
        String zh5;
        MatchResult matchResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(obj, "$obj");
        arrayList = this$0.grouplist;
        Object obj2 = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj2, "grouplist[0]");
        Group group = (Group) obj2;
        Iterator<com.tencent.mobileqq.widget.listitem.a<?>> it = group.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.widget.listitem.a<?> next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig<com.tencent.mobileqq.widget.listitem.SingleLineConfig.Left.Text, com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text>");
            ((x.c.g) ((x) next).O()).h("");
        }
        cl.j(this$0.getContext(), "current_version", "");
        com.tencent.mobileqq.widget.listitem.a<?> aVar = group.a().get(list.indexOf(item));
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig<com.tencent.mobileqq.widget.listitem.SingleLineConfig.Left.Text, com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text>");
        this$0.currentCfg = (x) aVar;
        this$0.Fh("\u4e0b\u8f7d\u4e2d");
        QLog.i("IphoneTitleBarFragment", 2, "data0 -" + obj.getSecond());
        zh5 = this$0.zh((String) obj.getSecond());
        QLog.i("IphoneTitleBarFragment", 2, "data1 -" + ((Object) zh5));
        Object second = obj.getSecond();
        if (zh5 != null) {
            matchResult = Regex.find$default(new Regex(">(\\d{8}[^\\/]+)\\/"), zh5, 0, 2, null);
        } else {
            matchResult = null;
        }
        Object obj3 = second;
        if (matchResult != null) {
            String str = second + ((Object) matchResult.getGroupValues().get(1)) + "/";
            QLog.i("IphoneTitleBarFragment", 2, "data3 -" + ((Object) str));
            zh5 = this$0.zh(str);
            obj3 = str;
        }
        QLog.i("IphoneTitleBarFragment", 2, "data4 -" + ((Object) zh5));
        if (zh5 != null) {
            matchResult = Regex.find$default(new Regex(">(groupvideo-[^<]+-qshadow-pack-release.zip)"), zh5, 0, 2, null);
        }
        if (matchResult != null) {
            String str2 = matchResult.getGroupValues().get(1);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(obj3);
            sb5.append((Object) str2);
            String sb6 = sb5.toString();
            QLog.i("IphoneTitleBarFragment", 2, "data5 -" + ((Object) sb6));
            com.tencent.mobileqq.groupvideo.debug.a a16 = com.tencent.mobileqq.groupvideo.debug.a.INSTANCE.a();
            if (a16 != null) {
                a16.c(sb6, "/sdcard/Android/data/com.tencent.mobileqq/files/qshadow-plugins", "GroupVideo.apk", new a(this$0));
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        final GroupVideoVersionListFragment groupVideoVersionListFragment = this.this$0;
        final List<Pair<String, String>> list = this.$list;
        final Pair<String, String> pair = this.$item;
        final Pair<String, String> pair2 = this.$obj;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.debug.i
            @Override // java.lang.Runnable
            public final void run() {
                GroupVideoVersionListFragment$createVersionGroups$1.b(GroupVideoVersionListFragment.this, list, pair, pair2);
            }
        }, 128, null, false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/groupvideo/debug/GroupVideoVersionListFragment$createVersionGroups$1$a", "Lcom/tencent/mobileqq/groupvideo/debug/a$b;", "Ljava/io/File;", "file", "", "b", "", "progress", "a", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onDownloadFailed", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GroupVideoVersionListFragment f213762a;

        a(GroupVideoVersionListFragment groupVideoVersionListFragment) {
            this.f213762a = groupVideoVersionListFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupVideoVersionListFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(GroupVideoVersionListFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this$0.getContext(), 230);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026,DialogUtil.ALERT_DIALOG)");
            createCustomDialog.setTitle("\u63d0\u793a");
            createCustomDialog.setMessage("\u5207\u6362\u63d2\u4ef6\u7248\u672c\u7248\u672c\u9700\u8981\u91cd\u542f\u624bQ");
            createCustomDialog.setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.groupvideo.debug.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GroupVideoVersionListFragment$createVersionGroups$1.a.f(dialogInterface, i3);
                }
            });
            createCustomDialog.show();
        }

        @Override // com.tencent.mobileqq.groupvideo.debug.a.b
        public void a(int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, progress);
                return;
            }
            this.f213762a.Fh(progress + "%");
        }

        @Override // com.tencent.mobileqq.groupvideo.debug.a.b
        public void b(@Nullable File file) {
            String str;
            x xVar;
            x.b.d dVar;
            CharSequence text;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) file);
                return;
            }
            if (file != null) {
                final GroupVideoVersionListFragment groupVideoVersionListFragment = this.f213762a;
                IHuayangOpenHelper iHuayangOpenHelper = (IHuayangOpenHelper) QRoute.api(IHuayangOpenHelper.class);
                Context context = groupVideoVersionListFragment.getContext();
                Context context2 = groupVideoVersionListFragment.getContext();
                if (context2 != null) {
                    str = context2.getPackageName();
                } else {
                    str = null;
                }
                iHuayangOpenHelper.killProcess(context, str + ":troophomework");
                groupVideoVersionListFragment.Fh("\u5e94\u7528\u6210\u529f");
                xVar = groupVideoVersionListFragment.currentCfg;
                if (xVar != null && (dVar = (x.b.d) xVar.K()) != null && (text = dVar.getText()) != null) {
                    cl.j(groupVideoVersionListFragment.getContext(), "current_version", (String) text);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.debug.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        GroupVideoVersionListFragment$createVersionGroups$1.a.e(GroupVideoVersionListFragment.this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.groupvideo.debug.a.b
        public void onDownloadFailed(@Nullable Exception e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) e16);
                return;
            }
            QLog.i("IphoneTitleBarFragment", 2, "err -" + e16);
            this.f213762a.Fh("\u4e0b\u8f7d\u5931\u8d25");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(DialogInterface dialogInterface, int i3) {
        }
    }
}

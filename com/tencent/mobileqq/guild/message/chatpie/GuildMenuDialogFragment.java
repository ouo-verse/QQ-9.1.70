package com.tencent.mobileqq.guild.message.chatpie;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.emoj.f;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildRecentUseEmojiHandler;
import com.tencent.mobileqq.guild.message.chatpie.GuildMenuDialogFragment;
import com.tencent.mobileqq.guild.message.v;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.XListView;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import oi1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMenuDialogFragment extends BottomSheetDialogFragment {
    private AppRuntime C;
    private com.tencent.mobileqq.utils.dialogutils.a D;
    private ChatMessage E;
    private View F;
    private wt1.b G;
    private XListView H;
    private f I;
    private com.tencent.mobileqq.guild.emoj.b J;
    private final v K = new a();
    private final GuildEventFlowObserver L = new b();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends v {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.message.v
        protected void a(boolean z16, Object obj) {
            QLog.d("GuildMenuDialogFragment", 1, "handleRecentUsedEmojis isSuccess=", Boolean.valueOf(z16));
            if (z16) {
                GuildMenuDialogFragment.this.yh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GuildEventFlowObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.message.GuildEventFlowObserver
        protected void c(String str, MessageRecord messageRecord) {
            if (GuildMenuDialogFragment.this.E != null && messageRecord != null && TextUtils.equals(str, GuildMenuDialogFragment.this.E.frienduin) && messageRecord.shmsgseq == GuildMenuDialogFragment.this.E.shmsgseq) {
                GuildMenuDialogFragment.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f230340d;

        c(List list) {
            this.f230340d = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GuildMenuDialogFragment.this.dismiss();
            com.tencent.mobileqq.guild.message.chatpie.a.D(GuildMenuDialogFragment.this.J, GuildMenuDialogFragment.this.F.getHeight(), this.f230340d, GuildMenuDialogFragment.this.I);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SystemAndEmojiEmoticonInfo f230342d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f230343e;

        d(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3) {
            this.f230342d = systemAndEmojiEmoticonInfo;
            this.f230343e = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
            GuildMenuDialogFragment.this.I.a(GuildMenuDialogFragment.this.J.f217873g, GuildMenuDialogFragment.this.J.f217872f, GuildMenuDialogFragment.this.J.f217870d, i3, systemAndEmojiEmoticonInfo.emotionType, true);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("GuildMenuDialogFragment", 1, "updateEmojiBg info.type=" + this.f230342d.type + ", info.code=" + this.f230342d.code);
            Context context = view.getContext();
            if (!NetworkUtil.isNetworkAvailable(context)) {
                QQToast.makeText(context, context.getString(R.string.f1510816q), 0).show();
            } else {
                qi1.a.e(view, this.f230342d, this.f230343e, GuildMenuDialogFragment.this.J.f217872f);
                ((Vibrator) context.getSystemService("vibrator")).vibrate(20L);
                final int serverId = QQSysAndEmojiResMgr.getInstance().getResImpl(this.f230342d.emotionType).getServerId(this.f230342d.code);
                g.e().i(this.f230342d);
                GuildMenuDialogFragment.this.dismiss();
                if (GuildMenuDialogFragment.this.I != null) {
                    Handler handler = new Handler();
                    final SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = this.f230342d;
                    handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.message.chatpie.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildMenuDialogFragment.d.this.b(serverId, systemAndEmojiEmoticonInfo);
                        }
                    }, 100L);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildMenuDialogFragment(com.tencent.mobileqq.guild.emoj.b bVar, AppRuntime appRuntime, com.tencent.mobileqq.utils.dialogutils.a aVar, ChatMessage chatMessage) {
        this.J = bVar;
        this.C = appRuntime;
        this.D = aVar;
        this.E = chatMessage;
    }

    private void Ah(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_aio_menu");
        HashMap hashMap = new HashMap();
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(this.E.frienduin, hashMap);
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    private void Dh(List<EmotionPanelData> list, int i3, int i16) {
        EmotionPanelData emotionPanelData = list.get(i3);
        if (!(emotionPanelData instanceof SystemAndEmojiEmoticonInfo)) {
            QLog.e("GuildMenuDialogFragment", 1, "updateEmojiBg invalid type data=" + emotionPanelData);
            return;
        }
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
        Drawable drawable = systemAndEmojiEmoticonInfo.getDrawable(true);
        URLImageView uRLImageView = (URLImageView) this.F.findViewById(i16);
        uRLImageView.setBackgroundDrawable(drawable);
        uRLImageView.setOnClickListener(new d(systemAndEmojiEmoticonInfo, i3));
    }

    private void initUI() {
        int i3;
        wt1.b bVar = new wt1.b(this);
        this.G = bVar;
        bVar.e(this.J.f217869c);
        this.G.c(this.D);
        this.G.f(this.E.msgtype);
        boolean c16 = su1.c.c(this.E);
        wt1.b bVar2 = this.G;
        if (c16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        bVar2.g(i3);
        XListView xListView = (XListView) this.F.findViewById(R.id.z4u);
        this.H = xListView;
        xListView.setOverScrollMode(2);
        this.H.setAdapter((ListAdapter) this.G);
        zh();
        xh();
        yh();
    }

    private void uh() {
        if (!vh()) {
            return;
        }
        QLog.d("GuildMenuDialogFragment", 1, "fetchRecentUseEmojis");
        ((IGuildRecentUseEmojiHandler) ((AppInterface) this.C).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRecentUseEmojiHandlerName())).reqRecentUseEmojiList();
    }

    private boolean vh() {
        if (this.J.f217869c == 1 && !((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(this.E) && !((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isNotSuccess(this.E)) {
            return true;
        }
        return false;
    }

    private void xh() {
        wt1.b bVar = this.G;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        if (!vh()) {
            return;
        }
        List<EmotionPanelData> f16 = g.e().f();
        Dh(f16, 0, R.id.dcf);
        Dh(f16, 1, R.id.dcg);
        Dh(f16, 2, R.id.dch);
        Dh(f16, 3, R.id.dci);
        Dh(f16, 4, R.id.dcj);
        Dh(f16, 5, R.id.dck);
        if (bi.d() <= 750) {
            this.F.findViewById(R.id.dck).setVisibility(8);
        }
        this.F.findViewById(R.id.f165755xi2).setOnClickListener(new c(f16));
        View findViewById = this.F.findViewById(R.id.yfd);
        int d16 = (int) (bi.d() * 0.042d);
        findViewById.setPadding(d16, findViewById.getPaddingTop(), d16, findViewById.getPaddingBottom());
        if (this.J.f217868b) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void zh() {
        if (this.J.f217869c == 5) {
            this.F.findViewById(R.id.f99695qh).setBackgroundResource(R.drawable.guild_live_drag_popup_top_gray_layout);
            this.F.setBackgroundResource(R.drawable.guild_live_aio_msgmenu_bg);
        }
    }

    public void Ch(f fVar) {
        this.I = fVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.F = layoutInflater.inflate(R.layout.eet, viewGroup);
        initUI();
        Ah(this.F);
        uh();
        ((AppInterface) this.C).addObserver(this.K);
        ((AppInterface) this.C).addDefaultObservers(this.L);
        View view = this.F;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((AppInterface) this.C).removeObserver(this.K);
        ((AppInterface) this.C).removeObserver(this.L);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.F.getParent()).setBackgroundColor(0);
    }

    public void wh(com.tencent.mobileqq.utils.dialogutils.b bVar) {
        if (bVar == null) {
            return;
        }
        dismiss();
    }

    public void Bh(wt1.g gVar) {
    }
}

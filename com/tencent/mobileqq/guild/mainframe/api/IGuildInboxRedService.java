package com.tencent.mobileqq.guild.mainframe.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildInboxRedService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(@NonNull IGuildUnreadCntService.b bVar);

        void b(@NonNull List<cq> list);

        void c(@NonNull cq cqVar);
    }

    void addNoticeRedUpdateListener(a aVar);

    void clearAllNoticeRedPoint();

    void clearNoticeRedPoint(int i3);

    boolean fetchNoticeRedPoint(AppRuntime appRuntime);

    List<cq> getNoticeGroupList();

    IGuildUnreadCntService.b getNoticeRedCount();

    @NonNull
    cq getNoticeRedPoint(int i3);

    boolean needFetchNoticeRed();

    void removeNoticeRedUpdateListener(a aVar);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b implements a {
        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void a(@NonNull IGuildUnreadCntService.b bVar) {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void b(@NonNull List<cq> list) {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void c(@NonNull cq cqVar) {
        }
    }
}

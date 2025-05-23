package jj1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import co1.j;
import com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore;
import com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker;
import com.tencent.mobileqq.guild.feed.manager.info.GuildInfoField;
import com.tencent.mobileqq.guild.feed.util.UnsupportedFieldTypeException;
import com.tencent.richframework.data.base.BaseDataCenter;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import java.io.File;
import jl1.d;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b extends BaseDataCenter {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f409981a;

    b() {
        addDataConverter(new a());
        addDataConverter(new com.tencent.mobileqq.guild.feed.manager.info.b());
        addDataConverter(new d());
        addDataWorker(new GuildFeedWorker());
        addDataStore("GuildFeedTempDataStore", new GuildFeedTempDataStore());
    }

    public static void a() {
        b bVar = f409981a;
        if (bVar != null) {
            synchronized (b.class) {
                bVar.mAllGlobalStateData.clear();
                bVar.mObserverWrapperMap.clear();
                bVar.mObserverWrapperToLiveData.clear();
            }
        }
    }

    public static b c() {
        if (f409981a == null) {
            synchronized (b.class) {
                if (f409981a == null) {
                    f409981a = new b();
                }
            }
        }
        return f409981a;
    }

    @Deprecated
    public static String d(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("main_feed_list");
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str);
        sb5.append(str3);
        sb5.append(str2);
        return sb5.toString();
    }

    public <T> MutableLiveData<T> b(GuildInfoField guildInfoField, Class<T> cls, String str) {
        if (guildInfoField.getClassType() == cls) {
            return c().getGlobalData(cls, guildInfoField.name() + str);
        }
        throw new UnsupportedFieldTypeException("infoField except type:" + guildInfoField.getClassType() + ",but get type:" + cls);
    }

    public <T> void e(GuildInfoField guildInfoField, Class<T> cls, String str, Observer<T> observer) {
        if (guildInfoField.getClassType() == cls) {
            c().observerGlobalState(cls, guildInfoField.name() + str, observer);
            return;
        }
        throw new UnsupportedFieldTypeException("infoField except type:" + guildInfoField.getClassType() + ",but get type:" + cls);
    }

    public <T> void f(String str, GuildInfoField guildInfoField, Object obj) {
        if (guildInfoField.getClassType() == obj.getClass()) {
            c().updateState(guildInfoField.name() + str, obj);
            return;
        }
        throw new UnsupportedFieldTypeException("infoField except type:" + guildInfoField.getClassType() + ",but get type:" + obj.getClass());
    }

    @Override // com.tencent.richframework.data.base.BaseDataCenter
    public <T> void registerDisplaySurface(String str, IDataDisplaySurface<T> iDataDisplaySurface) {
        if (iDataDisplaySurface instanceof j) {
            ((j) iDataDisplaySurface).setIdentifier(str);
        }
        com.tencent.xaction.log.b.a("GuildDataCenter", 1, "registerDisplaySurface|key=" + str);
        super.registerDisplaySurface(str, iDataDisplaySurface);
    }
}

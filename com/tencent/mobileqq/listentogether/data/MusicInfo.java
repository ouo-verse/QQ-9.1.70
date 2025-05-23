package com.tencent.mobileqq.listentogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tencent.aio.media.aio_media$Song;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MusicInfo implements ISong {
    public static final Parcelable.Creator<MusicInfo> CREATOR = new a();
    public String C;
    public long D;
    public long E;
    public long F;
    public long G;
    public int H;
    public long I;

    /* renamed from: d, reason: collision with root package name */
    public String f240910d;

    /* renamed from: e, reason: collision with root package name */
    public String f240911e;

    /* renamed from: f, reason: collision with root package name */
    public String f240912f;

    /* renamed from: h, reason: collision with root package name */
    public List<String> f240913h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f240914i;

    /* renamed from: m, reason: collision with root package name */
    public String f240915m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<MusicInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MusicInfo createFromParcel(Parcel parcel) {
            return new MusicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MusicInfo[] newArray(int i3) {
            return new MusicInfo[i3];
        }
    }

    public MusicInfo() {
    }

    public static void e(QQAppInterface qQAppInterface, final int i3, final String str, final long j3, final Function1<String, Unit> function1) {
        if (qQAppInterface == null || j3 < 0) {
            function1.invoke("");
        }
        if (i3 == 2) {
            String g16 = ac.g(qQAppInterface, String.valueOf(j3), true);
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic", 2, " getSourceStr() type = " + i3 + " sessionUin = " + str + " shareUin =" + j3 + " nickName =" + g16);
            }
            if (TextUtils.isEmpty(g16)) {
                function1.invoke("");
            }
            function1.invoke("\u6765\u81ea" + g16 + "\u5206\u4eab");
            return;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(str, String.valueOf(j3), "AioShareMusic", new Function1() { // from class: c72.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k3;
                k3 = MusicInfo.k(i3, str, j3, function1, (TroopMemberNickInfo) obj);
                return k3;
            }
        });
    }

    public static int f(int i3) {
        if (i3 != 1) {
            return 0;
        }
        return R.drawable.hnz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit k(int i3, String str, long j3, Function1 function1, TroopMemberNickInfo troopMemberNickInfo) {
        String str2;
        if (troopMemberNickInfo == null) {
            str2 = "";
        } else {
            str2 = troopMemberNickInfo.getShowName();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic", 2, " getSourceStr() type = " + i3 + " sessionUin = " + str + " shareUin =" + j3 + " nickName =" + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            function1.invoke("");
        }
        function1.invoke("\u6765\u81ea" + str2 + "\u5206\u4eab");
        return null;
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public long H() {
        return this.I;
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public String I() {
        return ListenTogetherResDownloader.i(this.f240910d);
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public int J() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public List<String> Q() {
        return this.f240914i;
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public int S() {
        long j3 = this.D;
        if (j3 < 0) {
            return 0;
        }
        return (int) j3;
    }

    public int c() {
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MusicInfo) || TextUtils.isEmpty(this.f240910d)) {
            return false;
        }
        MusicInfo musicInfo = (MusicInfo) obj;
        return this.f240910d.equals(musicInfo.getId()) && c() == musicInfo.c();
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public String getAlbum() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public String getId() {
        return this.f240910d;
    }

    @Override // com.tencent.mobileqq.listentogether.data.ISong
    public String getTitle() {
        return this.f240911e;
    }

    public boolean j() {
        List<String> list = this.f240914i;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SongInfo{id='");
        sb5.append(this.f240910d);
        sb5.append('\'');
        sb5.append(", name='");
        sb5.append(this.f240911e);
        sb5.append('\'');
        sb5.append(", subTitle='");
        sb5.append(this.f240912f);
        sb5.append('\'');
        sb5.append(", urls='");
        List<String> list = this.f240914i;
        sb5.append(list == null ? 0 : list.size());
        sb5.append('\'');
        sb5.append(", lyric='");
        String str = this.f240915m;
        sb5.append(str != null ? str.length() : 0);
        sb5.append('\'');
        sb5.append(", album='");
        sb5.append(this.C);
        sb5.append('\'');
        sb5.append(", seek='");
        sb5.append(this.D);
        sb5.append('\'');
        sb5.append("ms, duration='");
        sb5.append(this.G);
        sb5.append('\'');
        sb5.append(", source='");
        sb5.append(this.H);
        sb5.append('\'');
        sb5.append(", shareUin='");
        sb5.append(this.I);
        sb5.append('\'');
        sb5.append('}');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f240910d);
        parcel.writeString(this.f240911e);
        parcel.writeString(this.f240912f);
        parcel.writeStringList(this.f240914i);
        parcel.writeString(this.f240915m);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeStringList(this.f240913h);
        parcel.writeLong(this.G);
        parcel.writeInt(this.H);
        parcel.writeLong(this.I);
    }

    MusicInfo(Parcel parcel) {
        this.f240910d = parcel.readString();
        this.f240911e = parcel.readString();
        this.f240912f = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f240914i = arrayList;
        parcel.readStringList(arrayList);
        this.f240915m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readLong();
        ArrayList arrayList2 = new ArrayList();
        this.f240913h = arrayList2;
        parcel.readStringList(arrayList2);
        this.G = parcel.readLong();
        this.H = parcel.readInt();
        this.I = parcel.readLong();
    }

    public static MusicInfo b(aio_media$Song aio_media_song) {
        String str;
        String str2;
        String str3;
        List<ByteStringMicro> list;
        if (aio_media_song == null) {
            return null;
        }
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.f240910d = aio_media_song.str_song_id.get();
        String str4 = "";
        if (aio_media_song.bytes_name.get() == null) {
            str = "";
        } else {
            str = aio_media_song.bytes_name.get().toStringUtf8();
        }
        musicInfo.f240911e = str;
        if (aio_media_song.bytes_sub_title.get() == null) {
            str2 = "";
        } else {
            str2 = aio_media_song.bytes_sub_title.get().toStringUtf8();
        }
        musicInfo.f240912f = str2;
        List<ByteStringMicro> list2 = aio_media_song.rpt_bytes_singer.get();
        musicInfo.f240913h = new ArrayList();
        if (list2 != null) {
            Iterator<ByteStringMicro> it = list2.iterator();
            while (it.hasNext()) {
                musicInfo.f240913h.add(it.next().toStringUtf8());
            }
        }
        musicInfo.f240914i = new ArrayList();
        if (aio_media_song.rpt_bytes_download_url.get() != null && (list = aio_media_song.rpt_bytes_download_url.get()) != null && list.size() > 0) {
            Iterator<ByteStringMicro> it5 = list.iterator();
            while (it5.hasNext()) {
                musicInfo.f240914i.add(it5.next().toStringUtf8());
            }
        }
        if (aio_media_song.bytes_lyric.get() == null) {
            str3 = "";
        } else {
            str3 = aio_media_song.bytes_lyric.get().toStringUtf8();
        }
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", ContainerUtils.FIELD_DELIMITER);
        }
        musicInfo.f240915m = str3;
        if (aio_media_song.bytes_cover.get() != null) {
            str4 = aio_media_song.bytes_cover.get().toStringUtf8();
        }
        musicInfo.C = str4;
        musicInfo.G = aio_media_song.uint32_duration.get();
        musicInfo.H = aio_media_song.enum_song_source.get();
        musicInfo.I = aio_media_song.uint64_sharer_uin.get();
        return musicInfo;
    }

    public static String g(int i3) {
        if (i3 == 1) {
            return "QQ\u97f3\u4e50";
        }
        if (i3 != 2) {
            return "";
        }
        return HardCodeUtil.qqStr(R.string.ocb);
    }
}

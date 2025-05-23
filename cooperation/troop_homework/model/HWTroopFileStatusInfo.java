package cooperation.troop_homework.model;

import com.tencent.mobileqq.troop.data.t;
import java.io.Serializable;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes28.dex */
public class HWTroopFileStatusInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int BusId;
    public int ErrorCode;
    public String FileName;
    public String FilePath;
    public UUID Id;
    public boolean IsNewStatus;
    public String LocalFile;
    public String NickName;
    public long ProgressTotal;
    public long ProgressValue;
    public int SeqId;
    public int Status;
    public String ThumbnailFile_Large;
    public String ThumbnailFile_Small;
    public long TroopUin;
    public int UploadTime;
    public long entrySessionID;
    public String sha1;
    public long uniseq;

    public static HWTroopFileStatusInfo parse(t tVar) {
        if (tVar == null) {
            return null;
        }
        HWTroopFileStatusInfo hWTroopFileStatusInfo = new HWTroopFileStatusInfo();
        hWTroopFileStatusInfo.Id = tVar.f294967a;
        hWTroopFileStatusInfo.SeqId = tVar.f294969c;
        hWTroopFileStatusInfo.uniseq = tVar.f294970d;
        hWTroopFileStatusInfo.TroopUin = tVar.f294971e;
        hWTroopFileStatusInfo.Status = tVar.f294972f;
        hWTroopFileStatusInfo.IsNewStatus = tVar.f294973g;
        hWTroopFileStatusInfo.ErrorCode = tVar.f294974h;
        hWTroopFileStatusInfo.UploadTime = tVar.f294975i;
        hWTroopFileStatusInfo.ProgressTotal = tVar.f294976j;
        hWTroopFileStatusInfo.ProgressValue = tVar.f294977k;
        hWTroopFileStatusInfo.LocalFile = tVar.f294978l;
        hWTroopFileStatusInfo.ThumbnailFile_Small = tVar.f294979m;
        hWTroopFileStatusInfo.ThumbnailFile_Large = tVar.f294980n;
        hWTroopFileStatusInfo.FilePath = tVar.f294985s;
        hWTroopFileStatusInfo.sha1 = tVar.f294986t;
        hWTroopFileStatusInfo.FileName = tVar.f294987u;
        hWTroopFileStatusInfo.BusId = tVar.f294988v;
        hWTroopFileStatusInfo.entrySessionID = tVar.f294989w;
        hWTroopFileStatusInfo.NickName = tVar.f294990x;
        return hWTroopFileStatusInfo;
    }

    public t toTroopFileStatusInfo() {
        t tVar = new t();
        tVar.f294967a = this.Id;
        tVar.f294969c = this.SeqId;
        tVar.f294970d = this.uniseq;
        tVar.f294971e = this.TroopUin;
        tVar.f294972f = this.Status;
        tVar.f294973g = this.IsNewStatus;
        tVar.f294974h = this.ErrorCode;
        tVar.f294975i = this.UploadTime;
        tVar.f294976j = this.ProgressTotal;
        tVar.f294977k = this.ProgressValue;
        tVar.f294978l = this.LocalFile;
        tVar.f294979m = this.ThumbnailFile_Small;
        tVar.f294980n = this.ThumbnailFile_Large;
        tVar.f294985s = this.FilePath;
        tVar.f294986t = this.sha1;
        tVar.f294987u = this.FileName;
        tVar.f294988v = this.BusId;
        tVar.f294989w = this.entrySessionID;
        tVar.f294990x = this.NickName;
        return tVar;
    }
}

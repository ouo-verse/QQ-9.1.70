package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetResponse {
    static final int CNAME = 4;
    static final int DELEGATION = 3;
    static final int DNAME = 5;
    static final int NXDOMAIN = 1;
    static final int NXRRSET = 2;
    static final int SUCCESSFUL = 6;
    static final int UNKNOWN = 0;
    private List<RRset> data;
    private int type;
    private static final SetResponse unknown = new SetResponse(0);
    private static final SetResponse nxdomain = new SetResponse(1);
    private static final SetResponse nxrrset = new SetResponse(2);

    SetResponse() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SetResponse ofType(int i3) {
        switch (i3) {
            case 0:
                return unknown;
            case 1:
                return nxdomain;
            case 2:
                return nxrrset;
            case 3:
            case 4:
            case 5:
            case 6:
                SetResponse setResponse = new SetResponse();
                setResponse.type = i3;
                setResponse.data = null;
                return setResponse;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addRRset(RRset rRset) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        this.data.add(rRset);
    }

    public List<RRset> answers() {
        if (this.type != 6) {
            return null;
        }
        return this.data;
    }

    public CNAMERecord getCNAME() {
        return (CNAMERecord) this.data.get(0).first();
    }

    public DNAMERecord getDNAME() {
        return (DNAMERecord) this.data.get(0).first();
    }

    public RRset getNS() {
        List<RRset> list = this.data;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    public boolean isCNAME() {
        if (this.type == 4) {
            return true;
        }
        return false;
    }

    public boolean isDNAME() {
        if (this.type == 5) {
            return true;
        }
        return false;
    }

    public boolean isDelegation() {
        if (this.type == 3) {
            return true;
        }
        return false;
    }

    public boolean isNXDOMAIN() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public boolean isNXRRSET() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    public boolean isSuccessful() {
        if (this.type == 6) {
            return true;
        }
        return false;
    }

    public boolean isUnknown() {
        if (this.type == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return "unknown";
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                return "delegation: " + this.data.get(0);
            case 4:
                return "CNAME: " + this.data.get(0);
            case 5:
                return "DNAME: " + this.data.get(0);
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SetResponse(int i3, RRset rRset) {
        if (i3 >= 0 && i3 <= 6) {
            this.type = i3;
            ArrayList arrayList = new ArrayList();
            this.data = arrayList;
            arrayList.add(rRset);
            return;
        }
        throw new IllegalArgumentException("invalid type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SetResponse(int i3) {
        if (i3 >= 0 && i3 <= 6) {
            this.type = i3;
            this.data = null;
            return;
        }
        throw new IllegalArgumentException("invalid type");
    }
}

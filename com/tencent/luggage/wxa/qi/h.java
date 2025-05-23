package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {
    public static int a(int i3) {
        w.d("MicroMsg.Record.RecordErrorHandler", "getErrIdKey errType:%d", Integer.valueOf(i3));
        switch (i3) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            default:
                switch (i3) {
                    case 15:
                        return 15;
                    case 16:
                        return 16;
                    case 17:
                        return 17;
                    case 18:
                        return 18;
                    case 19:
                        return 19;
                    case 20:
                        return 20;
                    case 21:
                        return 21;
                    case 22:
                        return 22;
                    case 23:
                        return 23;
                    case 24:
                        return 24;
                    case 25:
                        return 25;
                    case 26:
                        return 26;
                    default:
                        return 0;
                }
        }
    }

    public static String b(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("errType:" + i3 + ", err:");
        switch (i3) {
            case 1:
                sb5.append("error PCM record callback");
                break;
            case 2:
                sb5.append("init encoder fail, occur exception");
                break;
            case 3:
                sb5.append("encoder un initial occur exception");
                break;
            case 4:
                sb5.append("start record occur exception");
                break;
            case 5:
                sb5.append("resume record occur exception");
                break;
            case 6:
                sb5.append("fail to start record");
                break;
            case 7:
                sb5.append("fail to resume record");
                break;
            case 8:
                sb5.append("fail to pause record");
                break;
            case 9:
                sb5.append("fail to stop record");
                break;
            default:
                switch (i3) {
                    case 15:
                        sb5.append("check param invalid");
                        break;
                    case 16:
                        sb5.append("not support format type");
                        break;
                    case 17:
                        sb5.append("fail to init mp3 encoder");
                        break;
                    case 18:
                        sb5.append("mp3 file not found exception");
                        break;
                    case 19:
                        sb5.append("mp3 encode exception");
                        break;
                    case 20:
                        sb5.append("mp3 write buffer exception");
                        break;
                    case 21:
                        sb5.append("fail to init aac encoder");
                        break;
                    case 22:
                        sb5.append("fail to create mp4 file");
                        break;
                    case 23:
                        sb5.append("aac encode exception");
                        break;
                    case 24:
                        sb5.append("create cache file fail");
                        break;
                    case 25:
                        sb5.append("init encoder fail");
                        break;
                    case 26:
                        sb5.append("not support sample rate");
                        break;
                    default:
                        sb5.append("unknow error");
                        break;
                }
        }
        return sb5.toString();
    }
}

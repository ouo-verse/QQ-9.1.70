package com.tencent.gamecenter.wadl.sdk.downloader.pcdn;

import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    public static String a(int i3) {
        if (i3 != -2000) {
            if (i3 != 131075) {
                if (i3 != 196616) {
                    switch (i3) {
                        case -1003:
                            return "\u7f13\u51b2\u6587\u4ef6\u8bfb\u53d6\u9519\u8bef";
                        case -1002:
                            return "\u7f13\u51b2\u6587\u4ef6\u5199\u5165\u9519\u8bef";
                        case -1001:
                            return "\u7f13\u51b2\u6587\u4ef6\u521b\u5efa\u9519\u8bef";
                        case -1000:
                            return "\u7f13\u51b2\u6587\u4ef6\u5939\u521d\u59cb\u5316\u9519\u8bef";
                        default:
                            switch (i3) {
                                case 65537:
                                    return "\u76f8\u540c\u4efb\u52a1\u5df2\u5b58\u5728";
                                case 65538:
                                    return "\u4efb\u52a1\u542f\u52a8\u8d85\u65f6";
                                case 65539:
                                    return "\u5e76\u884c\u4e0b\u8f7d\u4efb\u52a1\u6570\u8d85\u8fc7\u4e0a\u9650";
                                default:
                                    switch (i3) {
                                        case 65542:
                                            return "filesize\u8bf7\u6c42\u5931\u8d25\uff0crangeEnd = -1\u65e0\u6cd5\u91cd\u7f6e";
                                        case 65543:
                                            return "cacheMgr\u5199\u6570\u636e\u5931\u8d25";
                                        case 65544:
                                            return "\u4efb\u52a1\u542f\u52a8\u540e\u4e00\u6bb5\u65f6\u95f4\u5185\u6ca1\u6709\u4efb\u4f55\u6570\u636e\u6765\u4e34(PCDN SDK\u5185\u90e8\u9519\u8bef\u7801)";
                                        default:
                                            switch (i3) {
                                                case 271336:
                                                    return "\u76f8\u540cpcdn\u4efb\u52a1\u5df2\u5b58\u5728";
                                                case 271337:
                                                    return "pcdn\u4efb\u52a1range\u8d85\u8fc7\u6587\u4ef6\u9650\u5236";
                                                case 271338:
                                                    return "pcdn\u4efb\u52a1\u8bf7\u6c42\u7684range\u8303\u56f4\u592a\u5c0f";
                                                default:
                                                    switch (i3) {
                                                        case 272336:
                                                            return "pcdn\u4efb\u52a1\u4e0b\u8f7d\u8d85\u65f6";
                                                        case 272337:
                                                            return "\u5e76\u884c\u4e0b\u8f7dpcdn\u4efb\u52a1\u8d85\u8fc7\u4e0a\u9650";
                                                        case 272338:
                                                            return "\u8bf7\u6c42p2p\u5e93\u4e0b\u8f7d\u5931\u8d25";
                                                        case 272339:
                                                            return "\u79cd\u5b50\u6587\u4ef6\u7684fileSize\u5927\u5c0f\u9519\u8bef";
                                                        case 272340:
                                                            return "\u8be5\u8d44\u6e90\u88ab\u540e\u53f0\u7981\u6b62\u67e5\u79cd\uff0c\u53ef\u80fd\u662f\u540e\u53f0\u6ca1\u6709\u505a\u79cd\uff0c\u6216\u8005\u540e\u53f0\u670d\u52a1\u8fc7\u8f7d\u7b49";
                                                        case 272341:
                                                            return "\u540e\u53f0\u914d\u7f6e\u7981\u7528PCDN\u4e0b\u8f7d";
                                                        case 272342:
                                                            return "\u5f53\u524d\u65e0\u53ef\u7528peer";
                                                        case 272343:
                                                            return "\u8fde\u7eed\u672a\u6765\u6570\u636e\u9519\u8bef";
                                                        default:
                                                            if (i3 >= 65636 && i3 <= 65686) {
                                                                return "cacheMgr\u5185\u90e8\u9519\u8bef";
                                                            }
                                                            return WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
                                                    }
                                            }
                                    }
                            }
                    }
                }
                return "p2p\u4efb\u52a1\u9519\u8bef";
            }
            return "\u4efb\u52a1\u542f\u52a8\u540e\u4e00\u6bb5\u65f6\u95f4\u5185\u6ca1\u6709\u4efb\u4f55\u6570\u636e\u6765\u4e34(\u91cd\u7f6e\u540e\u56de\u8c03\u7ed9\u4e1a\u52a1\u7684\u9519\u8bef\u7801)";
        }
        return "\u8fdb\u5ea6\u6761\u957f\u65f6\u95f4\u672a\u66f4\u65b0";
    }
}
